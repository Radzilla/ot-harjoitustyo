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

/**
 * Ball luokka käsittää peliruudussa näkyvän pallon ominaisuudet ja näitä
 * voidaan muokata ja välittää sovelluslogiikalle metodien avulla
 */
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

    /**
     * Metodin avulla saadaan tuotua luotu pallo peliruuttuun
     * @return palauttaa pallon geometrisena suorakulmiona
     */
    public Rectangle getBall() {
        return this.ball;
    }

    public int getSpeedX() {
        return this.speedX;
    }

    /**
     * Metodi collide tarkistaa mailan ja pallon yhteentörmäyksen
     * @param paddle Törmääminen pitää tarkistaa kummankin mailan kanssa
     * jotka annetaan parametrina
     * @return 
     */
    public boolean collide(Paddle paddle) {
        Shape collision = Shape.intersect(this.ball, paddle.getPaddle());
        return collision.getBoundsInLocal().getWidth() != -1;
    }

    /**
     * Kun pallo tormaa mailaan se saa uuden sivuttaissuuntaisen nopeuden
     * mailan voiman mukaan ja sivuttaisliikkeen mailan sen hetkisestä
     * liikkeestä tai seinään osuessaan hidastuu.
     * @param speed
     * @param newRotation 
     */
    public void ballSetSpeed(int speed, int newRotation) {
        this.speedX = this.speedX / 2 + speed;
        this.rotation = (this.rotation + newRotation) / 2;
    }

    /**
     * metodi move liikuttaa palloa peliruudussa sen ominaisuuksien mukaan ja
     * tarkistaa ettei pallo pääse karkaamaan ruudun ulkopuolelle muuttamalla
     * sen suuntaa.
     *
     * @param y Pallo saa tietoon miten korkea peliruutu on jotta se vaihtaa
     * suunttaa oikeasa kohdassa.
     */
    public void move(int y) {
        this.speedY = this.speedY/2 + this.rotation;

        this.ball.setTranslateX(this.ball.getTranslateX() + this.speedX);
        this.ball.setTranslateY(this.ball.getTranslateY() + this.speedY);
        if (this.ball.getTranslateY() <= -y / 2) {
            this.ball.setTranslateY(-y / 2);
            this.rotation = -this.rotation;
        }
        if (this.ball.getTranslateY() >= y / 2) {
            this.ball.setTranslateY(y / 2);
            this.rotation = -this.rotation;
        }
    }

}
