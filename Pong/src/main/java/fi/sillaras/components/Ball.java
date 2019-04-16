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
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.geometry.Point2D;

public class Ball {

    private int speedX, speedY, posX, posY, rotation;
    private Rectangle ball;

    public Ball(int posX, int posY) {
        this.speedX = 2;
        this.speedY = 0;
        this.rotation = 0;
        this.posX = posX;
        this.posY = posY;
        this.ball = new Rectangle(this.posX, this.posY, 10, 10);

    }

    public Rectangle getBall() {
        return this.ball;
    }

    public int getSpeedX() {
        return this.speedX;
    }

    public boolean collide(Paddle paddle) {
        Shape collision = Shape.intersect(this.ball, paddle.getPaddle());
        return collision.getBoundsInLocal().getWidth() != -1;
    }

    public void ballSetSpeed(int speed, int newRotation) {
        this.speedX = this.speedX / 2 + speed;
        this.rotation = (this.rotation + newRotation) / 2;
    }

    public void move(int y) {
        this.speedY = this.speedY / 2 + this.rotation;

        this.ball.setTranslateX(this.ball.getTranslateX() + this.speedX);
        this.ball.setTranslateY(this.ball.getTranslateY() + this.speedY);
        if (this.ball.getTranslateY() <= -y / 2) {
            this.ball.setTranslateY(-y / 2);
            //this.speedY = -this.speedY;
            this.rotation = -this.rotation;
        }
        if (this.ball.getTranslateY() >= y / 2) {
            this.ball.setTranslateY(y / 2);
            //this.speedY = -this.speedY;
            this.rotation = -this.rotation;
        }
    }

}
