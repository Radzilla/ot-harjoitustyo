package fi.sillaras.functionality;

import fi.sillaras.components.Ball;
import fi.sillaras.components.Paddle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.animation.AnimationTimer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.input.KeyCode;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Scenes luokka huolehtii käyttöliittymän erilaisten näkyminen esittämisestä
 * käyttäjälle ja luokassa on myös peliä ohjaava animation timer ja sen handle
 * metodi. Animation timerin avulla Scenes tarkkailee pelin tilannetta joka
 * ruudunpäivityksessö ja vaihtaa tilanteesta riippuen näkymää ehtojen
 * täyttyessä. Animation timer ohjaa myös pelivälineitä pelinäkymässä.
 *
 * @author sillaras
 */
public class Scenes extends Application {

    public int round;
    public String name;

    @Override
    public void start(Stage stage) throws Exception, IOException {

        int x = 1080;
        int y = 720;

        Pane gameScreen = new Pane();
        gameScreen.setPrefSize(x, y);

        Scores scores = new Scores();
        Paddle paddle1 = new Paddle(10, y);
        paddle1.addSpeed();
        Paddle paddle2 = new Paddle(x - 10, y);
        Ball ball1 = new Ball(10 + paddle1.getPower(), y / 2);

        stage.setTitle("Score: " + paddle1.getScore() + " - " + paddle2.getScore());

        Scene scene = new Scene(gameScreen);

        BorderPane instructionsScreen = new BorderPane();
        instructionsScreen.setPrefSize(x, y);
        Label instructionsLabel = new Label("Press UP and DOWN arrows to move paddle. \n"
                + "Ball gets sideway movement from paddles movement so move paddle when ball touches it to start. \n"
                + "Score point by hitting wall behind opposing paddle. \n"
                + "After getting 3 points you can upgrade your paddle but only speed increse works at the moment. ");
        TextField nameField = new TextField();
        Button okButton = new Button("Enter your player name (max 10 characters) and click to Start game");
        okButton.setOnAction((event) -> {
            if (nameField.getText().length() < 11 && nameField.getText().length() > 0) {
                scores.setName(nameField.getText());
                stage.setScene(scene);

            } else {
                okButton.setText("Invalid name! Try again");
            }

        });

        instructionsScreen.setTop(instructionsLabel);
        instructionsScreen.setLeft(nameField);
        instructionsScreen.setCenter(okButton);
        Scene instructionsScene = new Scene(instructionsScreen);

        stage.setScene(instructionsScene);

        gameScreen.getChildren().add(paddle1.getPaddle());
        gameScreen.getChildren().add(paddle2.getPaddle());
        gameScreen.getChildren().add(ball1.getBall());

        BorderPane optionScreen = new BorderPane();
        optionScreen.setPrefSize(x, y);

        Label victoryLabel = new Label("You won! Choose your reward.");
        Button sizeButton = new Button("Increase power");
        sizeButton.setOnAction((event) -> {

            paddle1.addPower();
            paddle2.addPower();
            stage.setTitle("Score: " + paddle1.getScore() + " - " + paddle2.getScore());
            stage.setScene(scene);
        });

        Button speedButton = new Button("Increase speed");
        speedButton.setOnAction((event) -> {
            paddle1.addSpeed();
            paddle2.addPower();
            stage.setTitle("Score: " + paddle1.getScore() + " - " + paddle2.getScore());
            stage.setScene(scene);
        });

        optionScreen.setTop(victoryLabel);
        optionScreen.setLeft(sizeButton);
        optionScreen.setRight(speedButton);
        Scene optionScene = new Scene(optionScreen);

        BorderPane lostScreen = new BorderPane();
        lostScreen.setPrefSize(x, y);
        Label highLabel = new Label("High Scores: ");
        Label scoresLabel = new Label("");

        Button lostButton = new Button("Try again");
        lostButton.setOnAction((event) -> {
            stage.setTitle("Score: " + paddle1.getScore() + " - " + paddle2.getScore());
            stage.setScene(scene);
        });

        lostScreen.setLeft(scoresLabel);
        lostScreen.setTop(highLabel);
        lostScreen.setCenter(lostButton);
        Scene lostScene = new Scene(lostScreen);

        stage.show();

        Map<KeyCode, Boolean> pressedButton = new HashMap<>();

        scene.setOnKeyPressed(event -> {
            pressedButton.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            pressedButton.put(event.getCode(), Boolean.FALSE);
        });

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (pressedButton.getOrDefault(KeyCode.UP, false)) {
                    paddle1.speedUp();
                }
                if (pressedButton.getOrDefault(KeyCode.DOWN, false)) {
                    paddle1.speedDown();
                }

                if (paddle2.getPaddle().getTranslateY() > ball1.getBall().getTranslateY()) {
                    paddle2.speedUp();
                }
                if (paddle2.getPaddle().getTranslateY() < ball1.getBall().getTranslateY()) {
                    paddle2.speedDown();
                }

                paddle1.move(y);
                paddle2.move(y);
                ball1.move(y);

                if (ball1.collide(paddle1)) {
                    ball1.ballSetSpeed(paddle1.getPower(), paddle1.getSpeed());
                }
                if (ball1.collide(paddle2)) {
                    ball1.ballSetSpeed(-paddle2.getPower(), paddle2.getSpeed());
                }
                if (ball1.getBall().getTranslateX() < -10) {
                    paddle2.setScore(paddle2.getScore() + 1);
                    stage.setTitle("Score: " + paddle1.getScore() + " - " + paddle2.getScore());
                    ball1.getBall().setTranslateX(-10);
                    ball1.ballSetSpeed(-ball1.getSpeedX(), 0);
                    if (paddle2.getScore() >= 3) {
                        pressedButton.put(KeyCode.UP, Boolean.FALSE);
                        pressedButton.put(KeyCode.DOWN, Boolean.FALSE);
                        ball1.ballSetSpeed(2, 0);
                        ball1.getBall().setTranslateY(0);
                        ball1.getBall().setTranslateX(0);
                        paddle1.getPaddle().setTranslateY(0);
                        paddle2.getPaddle().setTranslateY(0);
                        paddle2.setScore(0);
                        paddle1.setScore(0);
                        paddle2.resetPower();
                        paddle1.resetSize();
                        paddle1.resetSpeed();
                        try {
                            scores.setScore();
                        } catch (IOException ex) {
                            Logger.getLogger(Scenes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        scores.resetRound();

                        try {
                            scoresLabel.setText(scores.getScore());
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Scenes.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Scenes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        stage.setScene(lostScene);

                    }
                }
                if (ball1.getBall().getTranslateX() > x) {
                    paddle1.setScore(paddle1.getScore() + 1);
                    stage.setTitle("Score: " + paddle1.getScore() + " - " + paddle2.getScore());

                    ball1.getBall().setTranslateX(x);
                    ball1.ballSetSpeed(-ball1.getSpeedX(), 0);
                    if (paddle1.getScore() >= 1) {
                        pressedButton.put(KeyCode.UP, Boolean.FALSE);
                        pressedButton.put(KeyCode.DOWN, Boolean.FALSE);
                        ball1.ballSetSpeed(2, 0);
                        ball1.getBall().setTranslateY(0);
                        ball1.getBall().setTranslateX(0);
                        paddle1.getPaddle().setTranslateY(0);
                        paddle2.getPaddle().setTranslateY(0);
                        paddle2.setScore(0);
                        paddle1.setScore(0);
                        scores.addRound();
                        stage.setScene(optionScene);

                    }
                }

            }
        }.start();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
