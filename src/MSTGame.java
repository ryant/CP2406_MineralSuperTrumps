import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ryan Thorp on 02-Sep-16.
 */
public class MSTGame {

    private static final int NUM_CARDS_TO_DEAL = 8;
    private int numPlayers;
    public int dealerId;
    private MSTPlayer[] players;
    private MSTDeck deck;
    private int userId;

    public MSTGame(int numPlayers) {
        this.numPlayers = numPlayers;
        deck = new MSTDeck();
    }

    public int selectDealer() {
        Random random = new Random();
        dealerId = random.nextInt(numPlayers);
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

    public void playTheGame() {
        boolean gameIsOn = true;
        while (gameIsOn) {
            int idxPlayer = dealerId + 1;
            for (int i = idxPlayer; i < players.length; i++) {
                if(i == 0){
                    players[i] = new MSTPlayer("Player Id =" + i);
                }

            }

            break;

        }



    }

}
