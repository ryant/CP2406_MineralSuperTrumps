import java.util.Scanner;

/**
 * Created by Ryan Thorp on 02-Sep-16.
 */
public class MST {
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

        }

    }

    private static void showInstructions() {

    }

    private static void startNewGame() {
        int numOpponents = getNumOpponents();
        MSTGame game = new MSTGame(numOpponents);
        game.selectDealer();
        game.dealRandomCards();
    }

    public static int getNumOpponents() {
        int maxOpponents = 4;
        int minOpponents = 2;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of opponents between " + minOpponents + " and " + maxOpponents + " inclusive");
        int choice = input.nextInt();
        while (choice > maxOpponents && choice < minOpponents){
            System.out.println("Please input number of Opponents between " + minOpponents + " and " + maxOpponents + " inclusive");
            choice = input.nextInt();
        }
        return choice;
    }

    private static int getUserMenuChoice() {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Please input 1 or 2");
            input.nextInt();
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
