import javax.swing.*;
import java.awt.*;

/**
 * Created by Ryan Thorp on 16-Oct-16.
 */
public class GameFrame extends JFrame {
    private PlayerPanel playerPanel = new PlayerPanel();

    public GameFrame(){
        super("Mineral Super Trumps Game");
        setLayout(new BorderLayout());
        setSize(1152, 648);
        setLocationRelativeTo(null);
        setVisible(true);

        add(playerPanel, BorderLayout.SOUTH);

    }

}
