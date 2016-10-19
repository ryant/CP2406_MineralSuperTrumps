import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Ryan Thorp on 16-Oct-16.
 */
public class CardTablePanel extends JPanel {
    static JLabel currentCardLabel;

    public CardTablePanel() throws IOException {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER, 300, 150));
        setVisible(true);

        currentCardLabel = new JLabel();
        JLabel currentCatLabel = new JLabel("Current Category = " + new SelectCategoryGui().getCurrentCategory());
        add(currentCardLabel);
        add(currentCatLabel);


    }

}
