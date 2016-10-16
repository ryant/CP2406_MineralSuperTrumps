import javax.swing.*;
import java.awt.*;

/**
 * Created by Ryan Thorp on 16-Oct-16.
 */
public class PlayerPanel extends JPanel {
    private MSTPlayer player;
    MSTCard card;
    public PlayerPanel(){
        super();
        setLayout(new FlowLayout());
        setVisible(true);
//        for (int i = 0 ; i < (player.cards.size()); i++){
//            JButton card = new JButton();
//            add(card);
//        }
        for (int i = 0 ; i < 8; i++){
            JButton card = new JButton();
            add(card);
        }
    }
}
