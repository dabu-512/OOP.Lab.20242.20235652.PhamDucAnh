package hust.soict.hedspi.aims.screen.customer.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;


public class TestViewStoreScreen extends Application {

    private static Store store;
    private static Cart cart;
    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
    	store = new Store();
        cart = new Cart();
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f, "Roger Allers", 87));
        store.addMedia(new CompactDisc("Hits of 90s", "Music", 15.5f, "Various Artists",30, "Best Seller"));
        store.addMedia(new CompactDisc("Journey With You", "Music", 15.50f, "Queen", 60, "Iris"));
        store.addMedia(new Book("Design Patterns", "Programming", 35.0f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, "George Lucas", 124));
        store.addMedia(new Book("C Language", "Programming", 45.00f));
        store.addMedia(new CompactDisc("Lo-fi Chill", "Instrumental", 10.99f, "Various", 50, "LoChill"));
        store.addMedia(new CompactDisc("Rock Legends", "Rock", 18.0f, "RockStar", 70, "Thunder Band"));
        store.addMedia(new Book("Design Patterns", "Programming", 35.0f));
        store.addMedia(new Book("The Pragmatic Programmer", "Software", 38.5f));
        store.addMedia(new DigitalVideoDisc("Interstellar", "Sci-Fi", 25.5f, "Christopher Nolan", 169));
        store.addMedia(new DigitalVideoDisc("Gladiator", "Historical", 21.0f, "Ridley Scott", 155));
        store.addMedia(new DigitalVideoDisc("Shrek", "Animation", 17.0f, "Andrew Adamson", 90));
        store.addMedia(new DigitalVideoDisc("Joker", "Drama", 23.5f, "Todd Phillips", 122));
        store.addMedia(new CompactDisc("Jazz Essentials", "Jazz", 16.5f, "Jazz Band", 65, "Smooth Flow"));
        store.addMedia(new CompactDisc("Classical Moods", "Classical", 13.75f, "Various", 75, "Orchestra"));
        store.addMedia(new CompactDisc("EDM Beats", "EDM", 19.25f, "DJ Max", 45, "Pulse"));
        store.addMedia(new CompactDisc("Acoustic Nights", "Acoustic", 12.5f, "Guitar Hero", 55, "Nightfall"));
        store.addMedia(new CompactDisc("Vietnamese Hits", "V-Pop", 11.5f, "Various", 60, "Top V Hits"));
        store.addMedia(new Book("Refactoring", "Software Engineering", 42.0f));
        store.addMedia(new Book("Effective Java", "Programming", 37.5f));
        store.addMedia(new Book("Introduction to Algorithms", "Computer Science", 50.0f));
        store.addMedia(new Book("Head First Design Patterns", "Programming", 36.0f));
        store.addMedia(new Book("Domain-Driven Design", "Architecture", 46.0f));
        store.addMedia(new Book("The Art of Computer Programming", "CS Theory", 55.0f));
        CompactDisc brokenCD = new CompactDisc("Silent CD", "Music", 12.5f, "Ghost Artist", 40, "Ghost Band");
        store.addMedia(brokenCD);
        DigitalVideoDisc brokenDVD = new DigitalVideoDisc("Broken DVD", "Error ", 9.99f, "No Director", 0);
        store.addMedia(brokenDVD);
        launch(args);
    }
}
