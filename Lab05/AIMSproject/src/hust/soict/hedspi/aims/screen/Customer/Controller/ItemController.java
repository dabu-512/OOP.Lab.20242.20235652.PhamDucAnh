package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.media.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.LimitExceededException; 
import javafx.scene.control.Alert;
public class ItemController {

    private Media media;
    private Cart cart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }
    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (this.media != null && this.cart != null) {
            try {
                this.cart.addMedia(this.media);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Item Added");
                alert.setHeaderText(null);
                alert.setContentText("'" + this.media.getTitle() + "' has been added to your cart.");
                alert.showAndWait();
            } catch (LimitExceededException e) {
                System.err.println("Error adding item to cart: " + e.getMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Cart Full");
                alert.setHeaderText("Could not add '" + this.media.getTitle() + "' to cart.");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("An unexpected error occurred while adding the item.");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        } else {
            System.out.println("Error: Media item or Cart is null. Cannot add to cart.");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Add Item Error");
            alert.setHeaderText(null);
            alert.setContentText("Cannot add item. Media or Cart information is missing.");
            alert.showAndWait();
        }
    }
    
    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Playing Media");
                alert.setHeaderText(null);
                alert.setContentText("Now playing: " + media.getTitle());
                alert.showAndWait();

            } catch (Exception e) {
                System.err.println("Error playing media: " + e.getMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Play Error");
                alert.setHeaderText("Cannot play media.");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

}
