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
    public String currentCategory;
    public String selectedCategory;
    private int numPlayers;
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

        if (currentCard == null) {
            System.out.println("Select a card number");
            choice = input.nextInt() - 1;
        }
        if (currentCard != null) {
            System.out.println(currentCard);
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
                (selectedCategory.equals("Cleavage") || (selectedCategory.equals("Crustal Abundance") || (selectedCategory.equals("Economic Value")))))) {
            return false;
        }
        System.out.println("Please select a valid category");
        return true;
    }


    private boolean checkIfCardIsValid(int choice) {
        if (isItTrumpCard(choice)) {
            return false;
        }
        if (players[userId].cards.size() <= choice || choice < 0) {
            return true;
        }
        if (players[userId].cards.get(choice).getCardCategory(currentCategory) < currentCard.getCardCategory(currentCategory)) {
            System.out.println("Chosen card category value is to low");
            return true;
        }
        return false;
    }

    public void opponentTakeTurn() {
        int choice;

        Random random = new Random();
        MSTPlayer opponent = players[MSTCommandLine.currentPlayer];
        int cardCount = opponent.cards.size();

        if (currentCategory == null) {
            currentCategory = opponentChooseCategory();
        }
        if (currentCard == null) {
            System.out.println("Opponent is selecting a card");
            choice = random.nextInt(opponent.cards.size());
            currentCard = opponent.cards.remove(choice);
            System.out.println("Opponents chooses " + currentCard);
        }


        if (opponent.cards.size() == 0) {
            System.out.println("Opponent Wins.... You Loose");
        } else {
            for (int i = 0; i < opponent.cards.size(); i++) {
                choice = i;
                if (opponent.cards.get(choice).getCardCategory(currentCategory) < currentCard.getCardCategory(currentCategory)) {
                    System.out.println("Opponent is checking for a valid card");
                    cardCount--;
                    if (cardCount == 0) {
                        System.out.println("Opponent can't play any cards");
                        skipTurn();
                    }
                } else {
                    currentCard = opponent.cards.remove(choice);
                    System.out.println("\nOpponent chose: " + currentCard);
                    break;
                }

            }
        }

    }

    private void skipTurn() {
        MSTCommandLine.currentPlayer++;

    }

    public boolean isItTrumpCard(int choice) {
        MSTCard card = players[MSTCommandLine.currentPlayer].cards.get(choice);
        return card.getCardType().equals("trump");
    }


    private String opponentChooseCategory() {
        String[] categories = {"Hardness", "Cleavage", "Specific Gravity", "Crustal Abundance", "Economic Value"};
        String opponentCategoryChoice;
        System.out.println("Opponent chooses the category: ");
        opponentCategoryChoice = (categories[new Random().nextInt(categories.length)]);
        System.out.println(opponentCategoryChoice);
        return opponentCategoryChoice;

    }
}
