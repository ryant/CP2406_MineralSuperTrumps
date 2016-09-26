import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ryan Thorp on 02-Sep-16.
 */
public class MSTGame {

    private static final int NUM_CARDS_TO_DEAL = 8;
    private int numPlayers;
    public int dealerId;
    public MSTPlayer[] players;
    private MSTDeck deck = new MSTDeck();
    private int userId;


    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int selectDealer() {
        Random random = new Random();
        dealerId = random.nextInt((numPlayers - 1) + 1);
        System.out.println("dealer id = " + dealerId);
        return dealerId;
    }

    public void dealRandomCards() {
        players = new MSTPlayer[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new MSTPlayer("Player Id =" + i);
        }
        for (MSTPlayer player : players) {
            ArrayList<MSTCard> cards = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards(cards);

        }
    }

    public void setUser() {
        userId = 0;
    }

    public MSTPlayer getUser() {
        return players[userId];
    }



}
