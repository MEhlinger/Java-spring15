package chapter15;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Marshall Ehlinger
 * 
 *  Helper class for p15N1FourCards.
 * 
 */
public class CardPane extends StackPane {
    
        
    ImageView cards[] = new ImageView[4];
    private final int CENTER_VAL = 100;
    private final int OVERLAP_VAL = 80;
           
    public CardPane() {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new ImageView();
        }
        newCards();
    }
    
    private String randCard() {
        return "image/card/" + (int)Math.ceil(Math.random() * 54) + ".png";
        
    }
    
    public final void newCards() {
        this.getChildren().clear();
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new ImageView(new Image("image/card/" + (int)Math.ceil(Math.random() * 54) + ".png"));
            this.getChildren().add(cards[i]);
            StackPane.setMargin(cards[i], new Insets(0, this.CENTER_VAL, 0, (i * OVERLAP_VAL)));

        }
    }
}
