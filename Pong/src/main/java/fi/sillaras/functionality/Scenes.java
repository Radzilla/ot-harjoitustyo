/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.sillaras.functionality;

import fi.sillaras.components.Ball;
import fi.sillaras.components.Paddle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author sillaras
 */
public class Scenes extends Pong {

    public int x, y;
    public Paddle paddle1, paddle2;
    public Ball ball1;
    public Scenes scenes;
    public Stage stage;

    public Scenes(int x, int y, Paddle paddle1, Paddle paddle2, Ball ball1, Stage stage) {
        this.x = x;
        this.y = y;

        this.paddle1 = paddle1;
        this.paddle2 = paddle2;
        this.ball1 = ball1;
        //stage=stage;
       

    }

    public Scene getInstructionsScene() {

        BorderPane instructionsScreen = new BorderPane();
        instructionsScreen.setPrefSize(x, y);
        Label instructionsLabel = new Label("Press UP and DOWN arrows to move paddle. \n"
                + "Ball gets sideway movement from paddles movement so move paddle when ball touches it to start. \n"
                + "Score point by hitting wall behind opposing paddle. \n"
                + "After getting 3 points you can upgrade your paddle but only speed increse works at the moment");
        Button okButton = new Button("Start game");
        okButton.setOnAction((event) -> {
            instructionsScene = this.getGameScene();
            
        });

        instructionsScreen.setTop(instructionsLabel);
        instructionsScreen.setCenter(okButton);
        Scene instructionsScene = new Scene(instructionsScreen);
        return instructionsScene;
        //stage.setScene(instructionsScene);
        //stage.show();
    }
    

    public Scene getGameScene() {
        Pane screen = new Pane();
        screen.getChildren().add(this.paddle1.getPaddle());
        screen.getChildren().add(this.paddle2.getPaddle());
        screen.getChildren().add(this.ball1.getBall());
        
        
        
        Scene gameScene = new Scene(screen);
        //stage.setScene(gameScene);
        //stage.show();
        return gameScene;
    }
    

    public Scene getOptionScene() {
        BorderPane optionScreen = new BorderPane();
        optionScreen.setPrefSize(x, y);

        Label victoryLabel = new Label("You won! Choose your reward.");

        Button sizeButton = new Button("Increase size");
        sizeButton.setOnAction((event) -> {
            //paddle1.setSize(100);
            //paddle1.getPaddle().reshape(paddle1.getSize(), paddle1.getSize());
            //screen.getChildren().remove(paddle1.getPaddle());
            //screen.getChildren().add(paddle1.getPaddle());
            this.getGameScene();
        });

        Button speedButton = new Button("Increase speed");
        speedButton.setOnAction((event) -> {
            paddle1.setSpeed(1);
            this.getGameScene();
        });

        optionScreen.setTop(victoryLabel);
        optionScreen.setLeft(sizeButton);
        optionScreen.setRight(speedButton);
        Scene optionScene = new Scene(optionScreen);
        return optionScene;
    }

}
