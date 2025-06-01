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
        store.addMedia(new DigitalVideoDisc(1,"The Lion King", "Animation", 19.95f, "Roger Allers", 87));
        store.addMedia(new CompactDisc(2 , "Hits of 90s", "Music", 15.5f, "Various Artists",30, "Best Seller"));
        store.addMedia(new CompactDisc(3, "Journey With You", "Music", 15.50f, "Queen", 60, "Iris"));
        store.addMedia(new Book(4, "Design Patterns", "Programming", 35.0f));
        store.addMedia(new DigitalVideoDisc(5, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 124));
        store.addMedia(new Book(6, "C Language", "Programming", 45.00f));
        store.addMedia(new CompactDisc(7, "Lo-fi Chill", "Instrumental", 10.99f, "Various", 50, "LoChill"));
        store.addMedia(new CompactDisc(8, "Rock Legends", "Rock", 18.0f, "RockStar", 70, "Thunder Band"));
        store.addMedia(new Book(9, "Design Patterns", "Programming", 35.0f));
        store.addMedia(new Book(10, "The Pragmatic Programmer", "Software", 38.5f));

        launch(args);
    }
}
