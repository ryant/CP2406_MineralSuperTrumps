import java.util.ArrayList;

/**
 * Created by Ryan Thorp on 03-Sep-16.
 */
public class MSTPlayer {

    public ArrayList<MSTCard> cards;
    private String playerId;

    public MSTPlayer(String playerId) {
        this.playerId = playerId;
    }


    public void setCards(ArrayList<MSTCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return playerId;
    }
}
