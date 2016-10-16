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
    public static int numPlayers;
    private MSTDeck deck = new MSTDeck();
    public int userId;

    public static void setNumPlayers(int numberPlayers) {
        numPlayers = numberPlayers;
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


    public void userTakeTurn() {
        int choice;

        if (currentCategory == null) {
            currentCategory = selectCategory();
        }

        Scanner input = new Scanner(System.in);
        System.out.println("The Current Category is: " + currentCategory);
        System.out.println("\nThe Current Card is: \n" + currentCard);
        System.out.println("\nSelect a card number or enter 100 to skip turn and draw a card");
        choice = input.nextInt() - 1;
        if (choice == 99) {
            drawCard();
            return;
        }
        boolean isCardInvalid = true;
        while (isCardInvalid) {
            isCardInvalid = checkIfCardIsValid(choice);
            if (isCardInvalid) {
                System.out.println("Invalid Choice");
                System.out.println("Please select a valid card this time.");
                choice = input.nextInt() - 1;
                if (choice == 99) {
                    drawCard();
                    return;
                }
            }
        }
        currentCard = players[userId].cards.remove(choice);
        System.out.println(currentCard);


        if (currentCard == null) {
            System.out.println("Select a card number");
//            choice = input.nextInt() - 1;
        }
        if (currentCard != null) {
            if (isItTrumpCard(choice)) {
                if (currentCard.getTitle().equals("The Miner")) {
                    currentCategory = "Economic Value";

                }
                if (currentCard.getTitle().equals("The Petrologist")) {
                    currentCategory = "Crustal Abundance";

                }
                if (currentCard.getTitle().equals("The Mineralogist")) {
                    currentCategory = "Cleavage";

                }
                if (currentCard.getTitle().equals("The Geophysicist")) {
                    currentCategory = "Specific Gravity";

                }
                if (currentCard.getTitle().equals("The Geologist")) {
                    currentCategory = selectCategory();

                }
                System.out.println("The Current Category is: " + currentCategory);
            }
        }
        if (players[userId].cards.size() == 0) {
            endGame();
        }

    }

    private String selectCategory() {
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
        return selectedCategory;
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
        if (choice == 99) {
            skipTurn();
        } else if (players[userId].cards.size() <= choice || choice < 0) {
            return true;
        } else if (players[userId].cards.get(choice).getCardType().equals("trump")) {
            return false;
        }
        if (currentCard != null) {
            if (players[userId].cards.get(choice).getCardCategory(currentCategory) < currentCard.getCardCategory(currentCategory)) {
                System.out.println("Chosen card category value is to low");
                return true;
            }
        }
        return false;
    }

    public void opponentTakeTurn() {
        int choice;

        Random random = new Random();
        MSTPlayer opponent = players[MSTMain.currentPlayer];
        int cardCount = opponent.cards.size();

        if (currentCategory == null) {
            currentCategory = opponentChooseCategory();
        }
        if (currentCard == null) {
            System.out.println("Opponent is selecting a card\n");
            choice = random.nextInt(opponent.cards.size());
            currentCard = opponent.cards.remove(choice);
            System.out.println("\nOpponent chose: \n" + currentCard + "\n");

        }


        if (opponent.cards.size() == 0) {
            System.out.println("Opponent Wins.... You Loose");
            endGame();
        } else {
            for (int i = 0; i < opponent.cards.size(); i++) {
                choice = i;
                if (opponent.cards.get(choice).getCardCategory(currentCategory) < currentCard.getCardCategory(currentCategory)) {
                    System.out.println("Opponent is checking for a valid card");
                    cardCount--;
                    if (cardCount == 0) {
                        System.out.println("Opponent can't play any cards");
                        MSTCard drawnCard = deck.dealCards(1).remove(0);
                        System.out.println("Opponent draws a card\n");
                        opponent.cards.add(drawnCard);
                        break;
                    }
                } else {
                    currentCard = opponent.cards.remove(choice);
                    System.out.println("\nOpponent chose: \n" + currentCard + "\n");
                    break;
                }

            }
        }

    }

    private void endGame() {
        if (players[userId].cards.size() == 0) {
            System.out.println("\nYou have zero cards in your hand");
            System.out.println("Congrats!!! You are the Winner");
        } else {
            System.out.println("Sorry you lost!");
        }
        MSTMain.gameIsOn = false;
    }

    private void skipTurn() {
        System.out.println("Skip turn!");
        drawCard();
//        MSTMain.playTheGame();


    }

    public void drawCard() {
        System.out.println("Skipping turn and drawing a card");
        MSTCard drawnCard = deck.dealCards(1).remove(0);
        players[0].cards.add(drawnCard);
    }

    public boolean isItTrumpCard(int choice) {
        return currentCard.getCardType().equals("trump");
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
