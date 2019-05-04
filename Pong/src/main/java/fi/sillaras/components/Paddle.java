package fi.sillaras.components;

import javafx.scene.shape.Rectangle;
import javafx.geometry.Point2D;

import javafx.animation.AnimationTimer;

/**
 * Paddlen avulla luodaan pelaajien mailat ominaisuuksiseen ja se tarjoaa
 * metodit tiedon välittämiseksi myös Scenes luokalle
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

    /**
     * Mailoilla on eri arvoille (score,size,power,speed) omat getterit
     *
     * @return palauttaa halutun arvon
     */
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

    /**
     * Mailan eri ominaisuuksia(power,size,speed) voidaan myös kasvattaa
     */
    public void addPower() {
        this.power++;
    }

    /**
     * Ominaisuudet (power,size,speed) voidaan myös palauttaa oletusarvoihin
     */
    public void resetPower() {
        this.power = 3;
    }

    public void addSize() {
        this.size = this.size + 20;
    }

    public void resetSize() {
        this.size = 100;
    }

    public void addSpeed() {
        this.acceleration++;
    }

    public void resetSpeed() {
        this.acceleration = 3;
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
     * @param y parametrina saadaan peliruudun korkeus, millä asetetaan rajat
     * liikkeelle
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
