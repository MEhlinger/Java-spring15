package ps5;

import java.net.URL;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
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
    
    URL blipURL = getClass().getResource("/sounds/blip.wav");
    AudioClip blip = new AudioClip(blipURL.toString());
    
    URL popURL = getClass().getResource("/sounds/pop.wav");
    AudioClip pop = new AudioClip(popURL.toString());
    
    URL crowdURL = getClass().getResource("/sounds/crowdohh.wav");
    AudioClip crowd = new AudioClip(crowdURL.toString());
    
    final double RADIUS = 20;
    final double PADDLE_X = 400;
    final double PADDLE_Y = 200;
    final double PAD_WIDTH = 20;
    final double PAD_HEIGHT = 100;
    final double BALL_STARTX = 20;
    final double BALL_STARTY = 20;
    
    double ballX = BALL_STARTX; 
    double ballY = BALL_STARTY;
    double dx = 5; 
    double dy = 5;
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
            crowd.play();
            pause();
        }
        // Check if ball has bounced off of far wall
        if (ballX < RADIUS) {
            dx *= -1;
            blip.play();
        }
        // Check if ball has hit top or bottom of screen
        if (ballY < RADIUS || ballY > getHeight() - RADIUS) {
            dy = ++dy * -1;
            blip.play();
        }
        // Check if paddle hit ball
        if (ballX + RADIUS >= paddle.getX() && ballY < paddle.getY() + PAD_HEIGHT && ballY > paddle.getY()) {
            dx = ++dx * -1;
            pop.play();
        }
        
        // Update ball location
        ballX += dx;
        ballY += dy;
        ball.setCenterX(ballX);
        ball.setCenterY(ballY);
    }
    
    public void reset() {
        ballX = BALL_STARTX;
        ballY = BALL_STARTY;
    }
    
    
}
