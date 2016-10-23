import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Ryan Thorp on 15-Oct-16.
 */
public class MSTMenuView {
    public JFrame mainFrame;
    public static MSTGame game = new MSTGame();
    private JPanel menuPanel;
    private JButton intructionsBtn;
    private JButton startGameBtn;
    private JComboBox<Integer> selectNumPlayers;
    private JLabel labelNumPlayers;
    public static MSTPlayer[] players;




    public MSTMenuView() {
        mainFrame = new JFrame("Mineral Super Trumps");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(1152, 648);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);


        menuPanel = new JPanel();
        menuPanel.setVisible(true);
        mainFrame.add(menuPanel);

        startGameBtn = new JButton("Start Game");
        startGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                game.selectDealer();
                game.dealRandomCards();
                game.setUser();
                try {
                    new GameFrame(game.players);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });


        labelNumPlayers = new JLabel("Select Number of players including yourself");

        intructionsBtn = new JButton("Instructions");
        intructionsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame instructionsFrame = new JFrame("Instructions");
                instructionsFrame.setVisible(true);
                instructionsFrame.setSize(700, 700);
                instructionsFrame.setLocationRelativeTo(mainFrame);
                JPanel instructionsPane = new JPanel();
                JTextArea instructionsArea = new JTextArea();
                instructionsArea.setVisible(true);
                instructionsArea.setEditable(false);
                instructionsArea.append(MSTMain.showInstructions());
                instructionsPane.add(instructionsArea);
                instructionsFrame.add(instructionsPane);


            }
        });
        selectNumPlayers = new JComboBox<Integer>();
        selectNumPlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stringNumPlayers = selectNumPlayers.getSelectedItem().toString();
                System.out.println(stringNumPlayers);
                int numPlayers = Integer.parseInt(stringNumPlayers);
                MSTGame.setNumPlayers(numPlayers);
            }
        });
        selectNumPlayers.addItem(3);
        selectNumPlayers.addItem(4);
        selectNumPlayers.addItem(5);
        menuPanel.add(startGameBtn);
        menuPanel.add(intructionsBtn);
        menuPanel.add(labelNumPlayers);
        menuPanel.add(selectNumPlayers);
        mainFrame.revalidate();


    }
    public static void opponentTakeTurn() throws IOException {
        JOptionPane pane = new JOptionPane("Opponent Taking Turn", JOptionPane.PLAIN_MESSAGE);
        JDialog dialog = pane.createDialog("Opponent is selecting a card");

        dialog.addWindowListener(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        Timer timer = new Timer(1000, new ActionListener() { // 1 sec
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        timer.start();
        dialog.setVisible(true);

        Random random = new Random();
        MSTPlayer opponent = game.players[1];
        System.out.println("Opponent is selecting a card\n");
        int choice = random.nextInt(opponent.cards.size());
        MSTCard opponentCard = opponent.cards.remove(choice);
        System.out.println("\nOpponent chose: \n" + opponentCard + "\n");
        CardImage aiCardImage = new CardImage(opponentCard);
        CardTablePanel.currentCardLabel.setIcon(new ImageIcon(aiCardImage.cardImage));

        if(MSTMenuView.game.players[1].cards.size()== 0) {
            JOptionPane.showMessageDialog(null, "COMPUTER WINS!");
            System.exit(1);
        }
    }


}
