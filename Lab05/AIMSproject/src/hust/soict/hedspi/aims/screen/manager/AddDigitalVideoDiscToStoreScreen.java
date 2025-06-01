
package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	private static final long serialVersionUID = 1L;
    private JTextField tfDirector, tfLength;
    private JButton btnAdd;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);

        add(new JLabel("Director:"));
        tfDirector = new JTextField(20);
        add(tfDirector);

        add(new JLabel("Length (min):"));
        tfLength = new JTextField(20);
        add(tfLength);

        add(new JLabel(""));
        btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(new ButtonListener());
        add(btnAdd);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
            	int id = Integer.parseInt(tfId.getText().trim());
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                String director = tfDirector.getText().trim();
                int length = Integer.parseInt(tfLength.getText().trim());
                float cost = parseCost(); // parseCost() lấy từ AddItemToStoreScreen

                DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, director, length);
                store.addMedia(dvd);

                JOptionPane.showMessageDialog(null, "DVD added successfully!");
                dispose();
                new StoreManagerScreen(store);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid number format for length or cost.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
