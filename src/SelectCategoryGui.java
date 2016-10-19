import javax.swing.*;

/**
 * Created by Ryan Thorp on 19-Oct-16.
 */
public class SelectCategoryGui extends JFrame {
    public String currentCategory;

    public String getCurrentCategory() {
        Object[] categories = {"Hardness", "Specific Gravity",
                "Cleavage", "Crustal Abundance", "Economic Value"};
        int selection = -2;
        while (selection == -2) {
            selection = JOptionPane.showOptionDialog(new JOptionPane(), "Choose a category to play.", "Category Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, categories, categories[0]);
        }
        switch (selection) {
            case 0:
                currentCategory = "Hardness";
                break;
            case 1:
                currentCategory = "Specific Gravity";
                break;
            case 2:
                currentCategory = "Cleavage";
                break;
            case 3:
                currentCategory = "Crustal Abundance";
                break;
            case 4:
                currentCategory = "Economic Value";
                break;
        }
        return currentCategory;

    }
}



