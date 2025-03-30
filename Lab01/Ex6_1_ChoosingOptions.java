import javax.swing.JOptionPane;

public class Ex6_1_ChoosingOptions {
    public static void main(String[] args) {
        int option = JOptionPane.showOptionDialog(null,
                "Do you want to change to the first class ticket?",
                "Options",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null);

        JOptionPane.showMessageDialog(null, "You've chosen: "
                + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));

        System.exit(0);
    }
}
