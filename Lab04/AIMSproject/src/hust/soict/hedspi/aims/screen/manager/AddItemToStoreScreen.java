package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
	private static final long serialVersionUID = 1L;
    protected Store store;
    protected JTextField tfId, tfTitle, tfCategory, tfCost;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setLayout(new GridLayout(0,2,5,5));
        
        add(new JLabel("ID:"));
        tfId = new JTextField(20);
        add(tfId);
        
        add(new JLabel("Title:"));
        tfTitle = new JTextField(20);
        add(tfTitle);

        add(new JLabel("Category:"));
        tfCategory = new JTextField(20);
        add(tfCategory);

        add(new JLabel("Cost:"));
        tfCost = new JTextField(20);
        add(tfCost);

        setTitle("Add Item to Store");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    protected float parseCost() {
        try {
            return Float.parseFloat(tfCost.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid cost format!", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}