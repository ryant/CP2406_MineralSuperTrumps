import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ryan Thorp on 02-Sep-16.
 */
public class MSTGame {

    private static final int NUM_CARDS_TO_DEAL = 8 ;
    private int numOpponents;
    public int dealerId;
    private MSTPlayer [] players;
    private MSTDeck deck;
    int userId;

    public MSTGame (int numOpponents) {
        this.numOpponents = numOpponents;
        deck = new MSTDeck();
    }
    public int selectDealer() {
        Random random = new Random();
        dealerId = random.nextInt(numOpponents + 1);
        System.out.println("dealer id = " + dealerId);
        return dealerId;
    }

    public void dealRandomCards() {
        players = new MSTPlayer[numOpponents + 1];
        for (int i = 0; i < numOpponents + 1; i++){
            players[i] =new MSTPlayer("Player Id =" + i);
        }
        for (MSTPlayer player : players) {
            ArrayList<MSTCard> cards = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards(cards);

        }
    }

    public void selectUser() {
        userId = 0;
    }

    public MSTPlayer getHumanPlayer() {
        return players[userId];
    }
}
