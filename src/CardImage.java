import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ryan Thorp on 18-Oct-16.
 */
public class CardImage extends JPanel {
    private BufferedImage cardImage;
    private JButton cardView;
    private JLabel currentCardLabel = CardTablePanel.currentCardLabel;

    public CardImage(MSTCard card) throws IOException {
        try {
            String workingDirectory = System.getProperty("user.dir");
            cardImage = ImageIO.read(new File(workingDirectory + "/res/" + card.fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        cardImage = cardResize(cardImage, 250, 350, BufferedImage.TYPE_INT_ARGB);
        cardView = new JButton(new ImageIcon(cardImage));
        add(cardView);
        cardView.addActionListener(e -> {
            currentCardLabel.setIcon(new ImageIcon(cardImage));
            remove(cardView);
            revalidate();
        });
    }

    private BufferedImage cardResize(BufferedImage cardImage, int i, int i1, int typeIntArgb) {
        BufferedImage resizedImage = new BufferedImage(i, i1, typeIntArgb);
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.drawImage(cardImage, 0, 0, i, i1, null);
        graphics.dispose();
        return resizedImage;
    }

}
