/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sillaras
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class Pong  extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        PlayersPaddle paddle1 = new PlayersPaddle();
        Pane screen = new Pane();
        screen.setPrefSize(1280, 720);
        screen.getChildren().add(new Rectangle(10,310,paddle1.getPower(),paddle1.getSize()));
        
        Scene scene = new Scene(screen);
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
