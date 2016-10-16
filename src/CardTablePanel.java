import javax.swing.*;
import java.awt.*;

/**
 * Created by Ryan Thorp on 16-Oct-16.
 */
public class CardTablePanel extends JPanel {


    public CardTablePanel(){
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER, 200, 250));
        setVisible(true);

        JLabel currentCardLabel = new JLabel("Current Card");
        JLabel currentCatLabel = new JLabel("Current Category");
        JButton deckBtn = new JButton("Da Button");

        add(currentCardLabel);
        add(currentCatLabel);
        add(deckBtn);

    }

}
