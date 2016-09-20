import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ryan Thorp on 02-Sep-16.
 */
public class MSTGame {

    private static final int NUM_CARDS_TO_DEAL = 8 ;
    private int numOpponents = MST.getNumOpponents();
    public int dealerId;
    private MSTPlayer [] players;
    private MSTDeck deck;

    public MSTGame (int numOpponents) {
        this.numOpponents = numOpponents;
    }
    public int selectDealer() {
        Random random = new Random();
        dealerId = random.nextInt(numOpponents - 1) + 1;
        return dealerId;
    }

    public void dealRandomCards() {
        players = new MSTPlayer[numOpponents];
        for (MSTPlayer player : players) {
            ArrayList<MSTCard> card = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards(cards);

        }
    }
}
