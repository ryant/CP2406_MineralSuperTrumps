import javax.swing.*;
import java.awt.*;

/**
 * Created by Ryan Thorp on 16-Oct-16.
 */
public class CardTablePanel extends JPanel {

    static JLabel currentCardLabel;
    public CardTablePanel(){
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER, 300, 150));
        setVisible(true);

        currentCardLabel = new JLabel("Current Card");
        JLabel currentCatLabel = new JLabel("Current Category");
        JButton deckBtn = new JButton("Pick Up Card");

        add(currentCardLabel);
        add(currentCatLabel);
        add(deckBtn);

    }

}
