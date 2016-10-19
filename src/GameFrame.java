import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Ryan Thorp on 16-Oct-16.
 */
public class GameFrame extends JFrame {

    private PlayerPanel playerPanel;
    private CardTablePanel cardTablePanel = new CardTablePanel();

    public GameFrame(MSTPlayer[] players) throws IOException {
        super("Mineral Super Trumps Game");
        setLayout(new BorderLayout());
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        playerPanel = new PlayerPanel(players[0]);
        JScrollPane playerPanelScroll = new JScrollPane(playerPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(playerPanelScroll, BorderLayout.SOUTH);
        add(playerPanelScroll, BorderLayout.CENTER);
        add(cardTablePanel, BorderLayout.NORTH);

    }

}
