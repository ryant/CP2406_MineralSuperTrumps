import java.util.Scanner;

/**
 * Created by Ryan Thorp on 02-Sep-16.
 */
public class MSTCommandLine {
    private static final int NEW_GAME = 1;
    private static final int INSTRUCTIONS = 2;
    private static MSTGame game = new MSTGame();
    public static int currentPlayer = game.dealerId + 1;





    public static void main(String[] args) {
        showWelcome();
        showMenu();
        int opt;
        do {
            opt = getUserMenuChoice();
            switch (opt) {
                case NEW_GAME:
                    startNewGame();
                    playTheGame();
                    break;
                case INSTRUCTIONS:
                    showInstructions();
                    showMenu();
                    break;
            }
        }

        while (opt != NEW_GAME); {


        }

    }

    private static void playTheGame() {
        //game logic
        int currentPlayer = game.dealerId + 1;
        boolean gameIsOn = true;
        while (gameIsOn) {
            if (currentPlayer > game.players.length - 1) {
                currentPlayer = 0;
            }

            if (currentPlayer == 0) {
                showUserPlayer(game.getUser());
                //humanPlayer takes turn
                game.userTakeTurn();

            } else {
                game.opponentTakeTurn();
            }
            currentPlayer += 1;

        }
    }
    //todo: setup players in correct order

    private static void showInstructions() {
        System.out.println("How to play:" + '\n' + '\n' +
                "1. A dealer (randomly chosen) shuffles the cards and deals each player 8 cards." + '\n' +
                "Each player can look at their cards, but should not show them to other players." + '\n' +
                "The remaining card pack is placed face down on the table." + '\n' + '\n' +
                "2. The player to the left of the dealer goes first by placing a mineral card on the table." + '\n' +
                "The player must state the mineral name, one of the five playing categories" + '\n' +
                "(i.e., either Hardness, Specific Gravity, Cleavage, Crustal Abundance, or Economic Value)," + '\n' +
                "and the top value of that category. For example, a player placing the Glaucophane card may" + '\n' +
                "state Glaucophane, Specific Gravity, 3.2" + '\n' + '\n' +
                "3. The player next to the left takes the next turn. This player must play a mineral card" + '\n' +
                "that has a higher value in the playing category than the card played by the previous player." + '\n' +
                "For the example of the Glaucophane card above, the player must place a card that has a value" + '\n' +
                "for specific gravity above 3.2. The player must state the mineral name and value of the category" + '\n' +
                "when playing their card. The game continues with the next player to the left, and so on." + '\n' + '\n' +
                "4. If a player does not have any mineral cards that are of higher value for the specific category or" + '\n' +
                "trump being played, then the player must pass and pick up one card from the card pack on the table." + '\n' +
                "The player then cannot play again until all but one player has passed, or until another player throws" + '\n' +
                "a supertrump card to change the trump category, as described below. A player is allowed to pass even" + '\n' +
                "if they still hold cards that could be played." + '\n' + '\n' +
                "5. If the player has a supertrump card (The Mineralogist, The Geologist, The Geophysicist," + '\n' +
                "The Petrologist, The Miner, The Gemmologist) they may play this card at any of their turns." + '\n' +
                "By placing a supertrump card, the player changes the playing category or trump according to the" + '\n' +
                "instructions on the supertrump card. At this stage, any player who had passed on the previous round" + '\n' +
                "is now able to play again. If a player throws The Geophysicist card together with the Magnetite card," + '\n' +
                "then that player wins the hand." + '\n' + '\n' +
                "6. The game continues with players taking turns to play cards until all but one player has passed." + '\n' +
                "The last player then gets to lead out the next round and chooses the trump category to be played." + '\n' + '\n' +
                "7. The winner of the game is the first player to lose all of their cards. The game continues until" + '\n' +
                "all but one player (i.e., the loser) has lost their cards.\n");

    }


    private static void startNewGame() {
        int numPlayers = getNumPlayers();
        game.setNumPlayers(numPlayers);
        game.selectDealer();
        game.dealRandomCards();
        game.setUser();


    }


    private static void showUserPlayer(MSTPlayer user) {
        int cardNum = 1;
        for (MSTCard card : user.cards) {
            System.out.println("Card No: " + cardNum);
            System.out.println(card + "\n");
            cardNum++;
        }
    }


    public static int getNumPlayers() {
        int maxPlayers = 4;
        int minPlayers = 2;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of players between " + minPlayers + " and " + maxPlayers + " inclusive");
        int choice = input.nextInt();
        while (choice > maxPlayers || choice < minPlayers) {
            System.out.println("Please input number of players between " + minPlayers + " and " + maxPlayers + " inclusive");
            choice = input.nextInt();
        }
        return choice;
    }

    private static int getUserMenuChoice() {

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Please input 1 or 2");
            choice = input.nextInt();
        }
        return choice;
    }

    private static void showMenu() {
        System.out.println("1. Start Game");
        System.out.println("2. Instructions");
    }

    private static void showWelcome() {
        System.out.println("Welcome to \nMineral Super Trumps");
        System.out.println();
    }
}
