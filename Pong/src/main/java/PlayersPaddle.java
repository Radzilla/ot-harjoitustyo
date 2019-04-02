/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sillaras
 */
public class PlayersPaddle {
    
    private int size, power, accelecration, speed, friction;
    
    
    public PlayersPaddle() {
    this.size=100;
    this.power=5;
    this.speed=5;
    this.friction=1;
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
    
}

