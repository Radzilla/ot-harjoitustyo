/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fi.sillaras.components.Paddle;
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
        int x= 10;
        int y= 720;
        paddle1 = new Paddle(x,y);
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
        assertEquals(5, paddle1.getPower());
    }

    @Test
    public void parameterlessConstructorSetsSpeed() {
        assertEquals(0, paddle1.getSpeed());
    }
    @Test
    public void parameterlessConstructorSetsFriction() {
        assertEquals(1, paddle1.getFriction());
    }
}
