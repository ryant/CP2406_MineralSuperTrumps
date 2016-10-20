import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Ryan Thorp on 16-Oct-16.
 */
public class PlayerPanel extends JPanel {
    public static MSTPlayer player;
    public static MSTCard card;
    private static MSTDeck deck = new MSTDeck();


    public PlayerPanel(MSTPlayer player) throws IOException {
        super();
        player = player;
        setLayout(new FlowLayout());
        setVisible(true);
        JButton addCardBtn = new JButton("Pick Up Card");
        add(addCardBtn);
        for (MSTCard card : player.cards) {
            CardImage cards = new CardImage(card);
            add(cards);
        }

        addCardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCard();
                revalidate();
                try {
                    MSTMenuView.opponentTakeTurn();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }


        });
    }

    public void addCard() {
        MSTCard drawnCard = deck.dealCards(1).remove(0);
        System.out.println(drawnCard);

        try {
            add(new CardImage(drawnCard));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
