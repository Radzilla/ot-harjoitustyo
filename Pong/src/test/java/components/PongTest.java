package components;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fi.sillaras.components.Paddle;
import fi.sillaras.components.Ball;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sillaras
 */
public class PongTest {

    Paddle paddle1;
    Ball ball1;

    public PongTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        int x = 10;
        int y = 720;
        paddle1 = new Paddle(x, y);
        ball1 = new Ball(20, y / 2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void parameterlessConstructorSetsSize() {
        assertEquals(100, paddle1.getSize());
    }

    @Test
    public void parameterlessConstructorSetsPower() {
        assertEquals(3, paddle1.getPower());
    }

    @Test
    public void parameterlessConstructorSetsSpeed() {
        assertEquals(0, paddle1.getSpeed());
    }

    

    @Test
    public void parameterlessConstructorSetsBallSpeed() {
        assertEquals(2, ball1.getSpeedX());
    }

    @Test
    public void BallSetSpeed() {
        ball1.ballSetSpeed(3, 2);
        assertEquals(4, ball1.getSpeedX());
    }
}
