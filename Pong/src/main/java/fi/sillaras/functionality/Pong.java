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
import fi.sillaras.components.Paddle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
        Pane screen = new Pane();
        screen.setPrefSize(x, y);
        Paddle paddle1 = new Paddle(10, y);
        Paddle paddle2 = new Paddle(x - 10, y);
        //Ball ball1 = new Ball(10+paddle1.getPower(), y/2);

        //Rectangle pad1 = paddle1.getPaddle();
        screen.getChildren().add(paddle1.getPaddle());
        screen.getChildren().add(paddle2.getPaddle());

        Scene scene = new Scene(screen);
        stage.setScene(scene);
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
                paddle1.getPaddle().setTranslateY(paddle1.getSpeed());

            }
        }.start();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
