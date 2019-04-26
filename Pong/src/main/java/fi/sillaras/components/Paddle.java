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

/**
 * Paddlen avulla luodaan pelaajien mailat ominaisuuksiseen ja se tarjoaa
 * metodit tiedon välittämiseksi myös itse sovelluslogiikalle
 */
public class Paddle {

    private Rectangle paddle;

    private Point2D movement;
    private int size, power, acceleration, speed, posX, posY, height, score;

    /**
     * Konstruktori luo mailat oletusominaisuuksilla ja sijoittaa ne ruudun
     * keskelle Maila sijoitetaan luodun peliruudun koon mukaan.
     *
     * @param posX Parametrina saatu peliruudun leveys
     * @param posY Parametrina saatu peliruudun korkeus
     */
    public Paddle(int posX, int posY) {

        this.score = 0;
        this.size = 100;
        this.power = 3;
        this.acceleration = 3;
        this.speed = 0;
        this.posX = posX;
        this.posY = posY / 2 - this.size / 2;
        this.height = posY;

        this.paddle = new Rectangle(this.posX, this.posY, this.power, this.size);
    }

    /**
     * Metodin avulla saadaan tuotua luotu maila peliruuttuun
     *
     * @return palauttaa mailan geometrisena suorakulmiona
     */
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
    
    public void setPower() {
        this.power++;
    }

    public void setSize(int change) {
        this.size = this.size + change;
    }

    public void setSpeed(int change) {
        this.acceleration = this.acceleration + change;
    }

    public void setScore(int score) {
        this.score = score;
    }
    /**
     * Metodi kiihdyttää mailoja ylöspäin
     */
    public void speedUp() {
        this.speed = this.speed - this.acceleration;

    }

    /**
     * Metodi kiihdyttää mailoja alaspäin
     */
    public void speedDown() {
        this.speed = this.speed + this.acceleration;

    }

    /**
     * Paddlen metodi move liikuttaa mailoja annetujen komentojen perusteellaa
     * ja tarkistaa etteivät mailat pääse peliruudun ulkopuoelle
     *
     * @param y parametrina saadaan peliruudun korkeus
     */
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
