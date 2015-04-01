package ps5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author Marshall Ehlinger
 */
public class BallControlPane extends Pane{
    
    private final int RADIUS = 50;
    private int x = RADIUS * 2;
    private int y = RADIUS * 2;
    private final Circle BALL = new Circle(x, y, RADIUS);
    private int dx = 0;
    private int dy = 0;
    private final Timeline ballAnimate;
    
    public BallControlPane() {
        BALL.setFill(Color.LAVENDER);
        BALL.setStroke(Color.BLACK);
        getChildren().add(BALL);
        
        this.ballAnimate = new Timeline(new KeyFrame(Duration.millis(5), e -> moveBall()));
        this.ballAnimate.setCycleCount(Timeline.INDEFINITE);
        this.ballAnimate.play();
    }
    
    public void unfreezeBall() {
        ballAnimate.play();
    }
    
    public void freezeBall() {
        ballAnimate.pause();
    }
    
    public final void moveBall() {
        // Check boundaries
        if (x < RADIUS || x > getWidth() - RADIUS) {
            dx *= -1; // Change ball move direction
        }
        if (y < RADIUS || y > getHeight() - RADIUS) {
            dy *= -1; // Change ball move direction
        }
        x += dx;
        y += dy;
        this.BALL.setCenterX(x);
        this.BALL.setCenterY(y);
    }
    
    public void keyUp() {
        dy = -1;
    }
    
    public void keyDown() {
        dy = 1;
    }
    
    public void keyRight() {
        dx = 1;
    }
    
    public void keyLeft() {
        dx = -1;
    }
    
    public void brake() {
        dx = 0;
        dy = 0;
    }
    
     
    
    
}
