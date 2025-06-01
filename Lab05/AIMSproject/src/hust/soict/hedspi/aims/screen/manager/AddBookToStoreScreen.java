package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private static final long serialVersionUID = 1L;
    private JButton btnAdd;

    public AddBookToStoreScreen(Store store) {
        super(store); 
        btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(new ButtonListener());
        add(new JLabel("")); // placeholder
        add(btnAdd);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	Book book = new Book(Integer.parseInt(tfId.getText().trim()), tfTitle.getText().trim(),
        						tfCategory.getText().trim(), parseCost());
            store.addMedia(book);
            JOptionPane.showMessageDialog(null, "Book added successfully!");
            dispose();
            new StoreManagerScreen(store);

        }
    }
}