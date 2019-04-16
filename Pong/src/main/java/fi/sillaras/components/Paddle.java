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
import javafx.scene.shape.Rectangle;
import javafx.geometry.Point2D;

import javafx.animation.AnimationTimer;

public class Paddle {

    private Rectangle paddle;
    private Point2D movement;
    private int size, power, acceleration, speed, friction, posX, posY, height, score;

    public Paddle(int posX, int posY) {

        this.score = 0;
        this.size = 100;
        this.power = 3;
        this.acceleration = 3;
        this.speed = 0;
        this.friction = 1;
        this.posX = posX;
        this.posY = posY / 2 - this.size / 2;
        this.height = posY;

        this.paddle = new Rectangle(this.posX, this.posY, this.power, this.size);
    }

    public Rectangle getPaddle() {
        return this.paddle;
    }

    public int getScore() {
        return this.score;
    }

    public int getSize() {
        return this.size;
    }

    public int getPower() {
        return this.power;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getFriction() {
        return this.friction;
    }

    /*public void setSize(int change) {
        this.size = this.size + change;
        this.paddle.setSize(this.size, this.speed);
    }*/
    public void setSpeed(int change) {
        this.acceleration = this.acceleration + change;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void speedUp() {
        this.speed = this.speed - this.acceleration;

    }

    public void speedDown() {
        this.speed = this.speed + this.acceleration;

    }

    public void move(int y) {

        this.speed = this.speed / 2;
        this.paddle.setTranslateY(this.paddle.getTranslateY() + this.speed);

        if (this.paddle.getTranslateY() < -y / 2 + this.size / 2) {
            this.paddle.setTranslateY(-y / 2 + this.size / 2);
        } else if (this.paddle.getTranslateY() > y / 2 - this.size / 2) {
            this.paddle.setTranslateY(y / 2 - this.size / 2);
        }
    }

}
