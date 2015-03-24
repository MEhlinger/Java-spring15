package chapter15;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import java.io.File;

/**
 *
 * @author Marshall Ehlinger
 * 
 *  Helper class for p15N1FourCards.
 * 
 */
public class CardPane extends FlowPane {
    
        
    Image card1 = new Image("image/card/1.png");
    Image card2 = new Image("image/card/2.png");
    Image card3 = new Image("image/card/3.png");
    Image card4 = new Image("image/card/4.png");
    
    ImageView cView1 = new ImageView(card1);
    ImageView cView2 = new ImageView(card2);
    ImageView cView3 = new ImageView(card3);
    ImageView cView4 = new ImageView(card4);
    
    File cardDir = new File("image/card");
    String cardFiles[];
           
    
    public CardPane() {
        this.cardFiles = cardDir.list();
        this.getChildren().addAll(cView1, cView2, cView3, cView4);
    }
    
    private String randCard() {
        Random rand = new Random();
        System.out.println(cardFiles[(int)Math.ceil(rand.nextFloat() * 52)]);
        return "";
    }
    
    public void newCards() {
        card1 = new Image(randCard());
        card2 = new Image(randCard());
        card3 = new Image(randCard());
        card4 = new Image(randCard());
    }
}
