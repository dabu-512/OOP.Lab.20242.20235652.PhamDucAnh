package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	private static final long serialVersionUID = 1L;
    private JTextField tfDirector, tfLength, tfArtist;
    private JButton btnAdd;
    
    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        
        add(new JLabel("Director:")); 
        tfDirector = new JTextField(20);
        add(tfDirector);

        add(new JLabel("Length (min):"));
        tfLength = new JTextField(20);
        add(tfLength);

        add(new JLabel("Artist:"));
        tfArtist = new JTextField(20);
        add(tfArtist);

        btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(new ButtonListener());
        add(new JLabel(""));  // Khoảng trống để nút Add canh đều
        add(btnAdd);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                String director = tfDirector.getText().trim();
                String artist = tfArtist.getText().trim();
                float cost = parseCost();
                int length = Integer.parseInt(tfLength.getText().trim());

                CompactDisc cd = new CompactDisc(title, category, cost, director, length, artist);
                store.addMedia(cd);

                JOptionPane.showMessageDialog(null, "CD added successfully!");
                dispose();
                new StoreManagerScreen(store);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid number format for cost or length.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}