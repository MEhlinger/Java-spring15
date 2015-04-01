package ps5;

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
    
    public final void newCards() {
        this.getChildren().clear();
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new ImageView(new Image("mycards/c" + (int)Math.ceil(Math.random() * 52) + ".gif"));
            this.getChildren().add(cards[i]);
            StackPane.setMargin(cards[i], new Insets(0, this.CENTER_VAL, 0, (i * OVERLAP_VAL)));

        }
    }
}