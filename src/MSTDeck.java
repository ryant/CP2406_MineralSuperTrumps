import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ryan Thorp on 02-Sep-16.
 */
public class MSTDeck {

    private static final int NUM_CARDS_INIT = 60;
    private ArrayList<MSTCard> cards;

    // List of all cards read from file or hard coded

    public MSTDeck(){
        cards = new ArrayList<MSTCard>();

        for (int i = 0; i < NUM_CARDS_INIT; i++) {
             cards.add(new MSTCard(i));
            // google how to create a random array of integers
        }


    }

    public ArrayList<MSTCard> dealCards(int numCardsToDeal) {
        ArrayList<MSTCard> res = new ArrayList<MSTCard>();
        for (int i = 0; i < numCardsToDeal; i++) {
            int idx = new Random().nextInt(cards.size());
            MSTCard card = cards.remove(idx);
            res.add(card);
            System.out.println("\n card = " + card);
        }
        return res;
    }
}
