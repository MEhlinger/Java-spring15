package ps5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * A single player game of pong... because that's something that people do?
 * 
 * 
 * @author Marshall Ehlinger
 */
public class N07PongPane extends Pane {
    
    final double RADIUS = 20;
    final double PADDLE_X = 400;
    final double PADDLE_Y = 200;
    final double PAD_WIDTH = 20;
    final double PAD_HEIGHT = 100;
    
    double ballX = 20; 
    double ballY = 20;
    double dx = 1; 
    double dy = 1;
    Circle ball = new Circle(ballX, ballY, RADIUS);
    Timeline animation;
    Rectangle paddle = new Rectangle(PADDLE_X, PADDLE_Y, PAD_WIDTH, PAD_HEIGHT);
    
    public N07PongPane() {
        ball.setFill(Color.GREEN);
        getChildren().add(ball);
        
        paddle.setFill(Color.BLUE);
        getChildren().add(paddle);
        
        animation = new Timeline(new KeyFrame(Duration.millis(20), e-> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    
    public void play() {
        animation.play();
    }
    
    public void pause() {
        animation.pause();
    }
    
    public void paddleMove(double py) {
        paddle.setY(py);
    }
    
    public final void moveBall() {
        // check if ball has passed paddle --> game over
        if (ballX > getWidth()) {
            pause();
        }
        // Check if ball has bounced off of far wall
        if (ballX < RADIUS) {
            dx *= -1;
        }
        // Check if ball has hit top or bottom of screen
        if (ballY < RADIUS || ballY > getHeight() - RADIUS) {
            dy = ++dy * -1;
        }
        // Check if paddle hit ball
        if (ballX + RADIUS >= paddle.getX() && ballY < paddle.getY() + PAD_HEIGHT && ballY > paddle.getY()) {
            dx = ++dx * -1;
        }
        
        // Update ball location
        ballX += dx;
        ballY += dy;
        ball.setCenterX(ballX);
        ball.setCenterY(ballY);
    }
    
    
}
