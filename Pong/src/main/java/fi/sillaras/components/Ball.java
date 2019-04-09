package fi.sillaras.components;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sillaras
 */
import javafx.scene.shape.Circle;

public class Ball {

    private int speedX, speedY, posX, posY;
    private Circle ball;

    public Ball(int posX, int posY) {
        this.speedX = 0;
        this.speedY = 0;
        this.posX = posX;
        this.posY = posY;

    }

}
