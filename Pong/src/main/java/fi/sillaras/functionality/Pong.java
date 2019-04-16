package fi.sillaras.functionality;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sillaras
 */
import fi.sillaras.components.Ball;
import fi.sillaras.components.Paddle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.animation.AnimationTimer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
//import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.input.KeyCode;

public class Pong extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        int x = 1280;
        int y = 720;
        int score1 = 0;
        int score2 = 0;

        Pane screen = new Pane();

        screen.setPrefSize(x, y);
        Paddle paddle1 = new Paddle(10, y);
        paddle1.setSpeed(1);
        Paddle paddle2 = new Paddle(x - 10, y);
        Ball ball1 = new Ball(10 + paddle1.getPower(), y / 2);

        Scene scene = new Scene(screen);
        stage.setTitle("Score: " + paddle1.getScore() + " - " + paddle2.getScore());

        BorderPane instructionsScreen = new BorderPane();
        instructionsScreen.setPrefSize(x, y);
        Label instructionsLabel = new Label("Press UP and DOWN arrows to move paddle. \n"
                + "Ball gets sideway movement from paddles movement so move paddle when ball touches it to start. \n"
                + "Score point by hitting wall behind opposing paddle. \n"
                + "After getting 3 points you can upgrade your paddle but only speed increse works at the moment");
        Button okButton = new Button("Start game");
        okButton.setOnAction((event) -> {
            stage.setScene(scene);
        });
        instructionsScreen.setTop(instructionsLabel);
        instructionsScreen.setCenter(okButton);
        Scene instructionsScene = new Scene(instructionsScreen);

        stage.setScene(instructionsScene);

        screen.getChildren().add(paddle1.getPaddle());
        screen.getChildren().add(paddle2.getPaddle());
        screen.getChildren().add(ball1.getBall());

        BorderPane optionScreen = new BorderPane();
        optionScreen.setPrefSize(x, y);

        Label victoryLabel = new Label("You won! Choose your reward.");

        Button sizeButton = new Button("Increase size");
        sizeButton.setOnAction((event) -> {
            //paddle1.setSize(100);
            //paddle1.getPaddle().reshape(paddle1.getSize(), paddle1.getSize());
            //screen.getChildren().remove(paddle1.getPaddle());
            //screen.getChildren().add(paddle1.getPaddle());
            stage.setScene(scene);
        });

        Button speedButton = new Button("Increase speed");
        speedButton.setOnAction((event) -> {
            paddle1.setSpeed(1);
            stage.setScene(scene);
        });

        optionScreen.setTop(victoryLabel);
        optionScreen.setLeft(sizeButton);
        optionScreen.setRight(speedButton);
        Scene optionScene = new Scene(optionScreen);

        BorderPane lostScreen = new BorderPane();
        lostScreen.setPrefSize(x, y);
        Label lostLabel = new Label("You lost! Press button to try again.");
        Button lostButton = new Button("Try again");
        lostButton.setOnAction((event) -> {
            stage.setScene(scene);
        });

        lostScreen.setTop(lostLabel);
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
                        ball1.ballSetSpeed(0, 0);
                        ball1.getBall().setTranslateY(0);
                        paddle1.getPaddle().setTranslateY(0);
                        paddle2.getPaddle().setTranslateY(0);
                        paddle2.setScore(0);
                        paddle1.setScore(0);
                        stage.setScene(lostScene);
                        stage.show();
                    }
                }
                if (ball1.getBall().getTranslateX() > x) {
                    paddle1.setScore(paddle1.getScore() + 1);
                    stage.setTitle("Score: " + paddle1.getScore() + " - " + paddle2.getScore());

                    ball1.getBall().setTranslateX(x);
                    ball1.ballSetSpeed(-ball1.getSpeedX(), 0);
                    if (paddle1.getScore() >= 3) {
                        ball1.ballSetSpeed(0, 0);
                        ball1.getBall().setTranslateY(0);
                        paddle1.getPaddle().setTranslateY(0);
                        paddle2.getPaddle().setTranslateY(0);
                        paddle2.setScore(0);
                        paddle1.setScore(0);
                        stage.setScene(optionScene);
                        stage.show();
                    }
                }

            }
        }.start();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
