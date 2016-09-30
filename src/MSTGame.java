import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Ryan Thorp on 02-Sep-16.
 */
public class MSTGame {

    private static final int NUM_CARDS_TO_DEAL = 8;
    public MSTCard currentCard;
    public int dealerId;
    public MSTPlayer[] players;
    private int numPlayers;
    private MSTDeck deck = new MSTDeck();
    private int userId;
    public String currentCategory;
    public String selectedCategory;

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
        System.out.println("Cards have been dealt!");
    }

    public void setUser() {
        userId = 0;
    }

    public MSTPlayer getUser() {
        return players[userId];
    }


    public int userTakeTurn() {
        int choice = 0;

        if (currentCategory == null) {
            Scanner getCategory = new Scanner(System.in);
            System.out.println("Enter desired category");

            selectedCategory = getCategory.nextLine();
            boolean isSelectionInvalid = true;
            while (isSelectionInvalid) {

                isSelectionInvalid = isSelectedCategoryValid(selectedCategory);
                if (isSelectionInvalid) {
                    System.out.println("Enter card category");
                    selectedCategory = getCategory.nextLine();
                }

            }
            currentCategory = selectedCategory;
        }



        Scanner input = new Scanner(System.in);
        System.out.println("Take your turn");
        if (currentCard != null) {
            System.out.println(currentCard);
            System.out.println("\nTake your turn");

            choice = input.nextInt() - 1;
            boolean isCardInvalid = true;
            while (isCardInvalid) {
                isCardInvalid = checkIfCardIsValid(choice);

                if (isCardInvalid) {
                    System.out.println("Invalid Choice");
                    System.out.println("Please select a valid card this time.");
                    choice = input.nextInt() - 1;
                }
            }
        }

        currentCard = players[userId].cards.remove(choice);
        if (players[userId].cards.size() == 0) {
            System.out.println("You Win!");
        }
        return choice;

    }

    private boolean isSelectedCategoryValid(String selectedCategory) {
        if (selectedCategory.equals("Hardness") || (selectedCategory.equals("Specific Gravity") ||
                (selectedCategory.equals("Cleavage") || (selectedCategory.equals("Crustal abundance") || (selectedCategory.equals("Economic value")))))) {
            return false;
        }
        System.out.println("Please select a valid category");
        return true;
    }


    private boolean checkIfCardIsValid(int choice) {

        if (players[userId].cards.size() <= choice  || choice < 0) {
            return true;
        }
        if (players[userId].cards.get(choice).getCardCategory(currentCategory) <= currentCard.getCardCategory(currentCategory)) {
            return true;
        }
        return false;
    }

    public void aiTakeTurn() {
        int choice;
        MSTPlayer opponent = players[MSTCommandLine.currentPlayer];
        if (currentCard != null) {
            System.out.println(currentCard);
            System.out.println("Opponent is selecting a card");
        }
        Random random = new Random();
        if (opponent.cards.size() == 0) {
            System.out.println("Opponent Wins.... You Loose");
        }

        choice = random.nextInt(opponent.cards.size());
        MSTCard cardSelected = opponent.cards.remove(choice);
        System.out.println("Opponents chooses " + cardSelected);

    }
}
