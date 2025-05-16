package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Lion King", "Animation", 19.95f,
				"Roger Allers", 87);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", 
            "Science Fiction", 24.95f, "George Lucas", 87);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Asladin", 
            "Animation", 18.99f, "Alan Becker", 89);
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		dvd1.play();
		dvd2.play();
		dvd3.play();
	}
}
