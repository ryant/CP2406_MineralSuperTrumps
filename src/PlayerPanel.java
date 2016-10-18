import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Ryan Thorp on 16-Oct-16.
 */
public class PlayerPanel extends JPanel {
    private MSTPlayer player;
    MSTCard card;
    public PlayerPanel(MSTPlayer player) throws IOException {
        super();
        this.player = player;
        setLayout(new FlowLayout());
        setVisible(true);

        for (MSTCard card: player.cards) {
            CardImage  cards = new CardImage(card);
            add(cards);
        }
    }
}
