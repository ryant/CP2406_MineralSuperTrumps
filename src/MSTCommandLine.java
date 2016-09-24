import java.util.Scanner;

/**
 * Created by Ryan Thorp on 02-Sep-16.
 */
public class MSTCommandLine {
    private static final Object NEW_GAME = 1;

    public static void main(String[] args) {
        showWelcome();
        showMenu();
        int opt = getUserMenuChoice();

        switch (opt) {
            case 1:
                startNewGame();
                break;
            case 2:
                showInstructions();
                getUserMenuChoice();


        }

    }

    private static void showInstructions() {


    }

    private static void startNewGame() {
        int numOpponents = getNumPlayers();
        MSTGame game = new MSTGame(numOpponents);
        game.selectDealer();
        game.dealRandomCards();
        game.selectUser();

        MSTPlayer humanPlayer = game.getHumanPlayer();
        showPlayer(humanPlayer);
    }

    private static void showPlayer(MSTPlayer humanPlayer) {
        System.out.println("Human Player=" + humanPlayer);
    }

    public static int getNumPlayers() {
        int maxPlayers = 4;
        int minPlayers = 2;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of opponents between " + minPlayers + " and " + maxPlayers + " inclusive");
        int choice = input.nextInt();
        while (choice > maxPlayers || choice < minPlayers){
            System.out.println("Please input number of Opponents between " + minPlayers + " and " + maxPlayers + " inclusive");
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
