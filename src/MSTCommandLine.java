import java.util.Scanner;

/**
 * Created by Ryan Thorp on 02-Sep-16.
 */
public class MSTCommandLine {
    private static final int NEW_GAME = 1;
    private static final int INSTRUCTIONS = 2;


    public static void main(String[] args) {
        showWelcome();
        showMenu();
        MSTGame game;
        int opt = getUserMenuChoice();
        switch (opt) {
            case NEW_GAME:
                game = startNewGame();
                game.playTheGame();
                break;
            case INSTRUCTIONS:
                showInstructions();
                getUserMenuChoice();


        }

    }

    private static void showInstructions() {


    }

    private static MSTGame startNewGame() {
        int numPlayers = getNumPlayers();
        MSTGame game = new MSTGame(numPlayers);
        game.selectDealer();
        game.dealRandomCards();
        game.setUser();
        MSTPlayer user = game.getUser();
        showPlayer(user);
//        game.playTheGame();
        return game;
    }

    private static void showPlayer(MSTPlayer humanPlayer) {
        System.out.println("Human Player = " + humanPlayer);
    }

    public static int getNumPlayers() {
        int maxPlayers = 4;
        int minPlayers = 2;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of players between " + minPlayers + " and " + maxPlayers + " inclusive");
        int choice = input.nextInt();
        while (choice > maxPlayers || choice < minPlayers){
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
