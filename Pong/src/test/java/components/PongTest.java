package components;


import fi.sillaras.components.Paddle;
import fi.sillaras.components.Ball;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javafx.scene.shape.Rectangle;

/**Testit pelivälineille eli mailoille ja pallolle
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
        int x = 1080;
        int y = 720;
        paddle1 = new Paddle(10, y);
        ball1 = new Ball(20, y);
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
    
    /*@Test
    public void parameterlessConstructorGetsRectangle() {
        assertEquals(new Rectangle(20, 720/2-50, 3, 100), paddle1.getPaddle());
    }*/

    @Test
    public void parameterlessConstructorSetsBallSpeed() {
        assertEquals(2, ball1.getSpeedX());
    }

    @Test
    public void BallSetSpeed() {
        ball1.ballSetSpeed(3, 2);
        assertEquals(4, ball1.getSpeedX());
    }
    
    @Test
    public void PaddleSpeedUp() {
        paddle1.speedUp();
        assertEquals(-3, paddle1.getSpeed());
    }
    @Test
    public void PaddleSpeedDown() {
        paddle1.speedDown();
        assertEquals(3, paddle1.getSpeed());
    }
    
    @Test
    public void PaddleAddSpeed() {
        paddle1.addSpeed();
        paddle1.speedUp();
        assertEquals(-4, paddle1.getSpeed());
    }
    
    @Test
    public void PaddleResetSpeed() {
        paddle1.addSpeed();
        paddle1.resetSpeed();
        paddle1.speedUp();
        assertEquals(-3, paddle1.getSpeed());
    }
    
    @Test
    public void PaddleAddPower() {
        paddle1.addPower();
        assertEquals(4, paddle1.getPower());
    }
    
   @Test
    public void PaddleResetPower() {
        paddle1.addPower();
        paddle1.addPower();
        paddle1.resetPower();
        assertEquals(3, paddle1.getPower());
    }
    
    @Test
    public void PaddleaddSize() {
        paddle1.addSize();
        assertEquals(120, paddle1.getSize());
    }
    
    @Test
    public void PaddleResetSize() {
        paddle1.addSize();
        paddle1.resetSize();
        assertEquals(100, paddle1.getSize());
    }
    
    @Test
    public void PaddleMoveSpeed() {
        paddle1.speedDown();
        paddle1.move(720);
        assertEquals(1, paddle1.getSpeed());
    }
}
