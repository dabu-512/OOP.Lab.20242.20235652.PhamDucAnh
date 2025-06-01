package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		
		cart.printCart();
		List<Media> mediae = new ArrayList<Media>();
		CompactDisc CD = new CompactDisc(1,"The Lion King", "Animation", 19.95f,
				"Roger Allers", 87, "Peter");
		DigitalVideoDisc dvd = new DigitalVideoDisc(3, "Star Wars", 
	            "Science Fiction", 24.95f, "George Lucas", 87);
		Book book = new Book(5, "C Language", "Programing", 30.00f);
		
		mediae.add(CD);
		mediae.add(dvd);
		mediae.add(book);
		book.addAuthor("Adam");
		book.addAuthor("Cinthya");
		for(Media m : mediae) {
			System.out.println(m.toString());
		}
		//id, title, category, cost, director, length
		/*DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Lion King", "Animation", 19.95f,
				"Roger Allers", 87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", 
            "Science Fiction", 24.95f, "George Lucas", 87);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Asladin", 
            "Animation", 18.99f, "Alan Becker", 89);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(dvd1);
        // Test the print method
        cart.printCart();
        //----------------------------------

        dvd1.play();
        // To-do: Test the search methods here
        ///
         */
	} 
}
