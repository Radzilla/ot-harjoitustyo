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
    private int size, power, acceleration, speed, friction, posX, posY;
    
    
    public Paddle(int posX, int posY) {
        
    this.size=100;
    this.power=5;
    this.acceleration=5;
    this.speed=0;
    this.friction=1;
    this.posX=posX;
    this.posY=posY/2-this.size/2;
    
    
    this.paddle=new Rectangle(this.posX,this.posY,this.power,this.size);
}
    public Rectangle getPaddle() {
        return this.paddle;
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
    
    public void speedUp() {
        this.speed=this.speed-this.acceleration;
        
    }
    public void speedDown() {
        this.speed=this.speed+this.acceleration;
        
    }
    public void move() {
        this.posY=posY+this.speed;
    }
}

