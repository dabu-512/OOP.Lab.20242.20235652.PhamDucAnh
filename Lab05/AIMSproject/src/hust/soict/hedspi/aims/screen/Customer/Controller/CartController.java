package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CartController {

	private Store store;
    private Cart cart;

    public CartController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label costLabel;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    private ToggleGroup filterCategory;

    private ObservableList<Media> observableMediaList;

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(
            new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(
            new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
            new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
            new PropertyValueFactory<Media, Float>("cost"));

        observableMediaList = FXCollections.observableArrayList(cart.getItemsOrdered());
        tblMedia.setItems(observableMediaList);

        costLabel.setText(String.format("%.1f $", cart.totalCost()));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);


        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });


        filterCategory = new ToggleGroup();
        radioBtnFilterId.setToggleGroup(filterCategory);
        radioBtnFilterTitle.setToggleGroup(filterCategory);


        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

    @FXML
    private void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            observableMediaList.remove(media);  
            costLabel.setText(String.format("%.1f $", cart.totalCost()));
        }
    }

    private void showFilteredMedia(String filter) {
        if (filter == null || filter.trim().isEmpty()) {
            tblMedia.setItems(observableMediaList); // Hiện lại toàn bộ
            return;
        }

        ObservableList<Media> filtered = FXCollections.observableArrayList();

        for (Media media : observableMediaList) {
            if (radioBtnFilterId.isSelected()) {
                if (String.valueOf(media.getId()).contains(filter)) {
                    filtered.add(media);
                }
            } else if (radioBtnFilterTitle.isSelected()) {
                if (media.getTitle().toLowerCase().contains(filter.toLowerCase())) {
                    filtered.add(media);
                }
            }
        }

        tblMedia.setItems(filtered);
    }

    
    @FXML
    private void btnViewStorePressed(ActionEvent event) {
        try {
        	System.out.println("Cart.fxml resource URL: " + getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml"));
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            loader.setController(new ViewStoreController(store, cart));

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            if (selectedMedia instanceof Playable) {
                try {
                    System.out.println("Playing: " + selectedMedia.getTitle() + "...");
                    ((Playable) selectedMedia).play();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Playing Media");
                    alert.setHeaderText(null);
                    alert.setContentText("Now playing: " + selectedMedia.getTitle());
                    alert.showAndWait();

                } catch (Exception e) {
                    System.err.println("Error playing media: " + e.getMessage());
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Playback Error");
                    alert.setHeaderText("Cannot play " + selectedMedia.getTitle());
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Not Playable");
                alert.setHeaderText(null);
                alert.setContentText(selectedMedia.getTitle() + " is not a playable media type.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a media item from the table to play.");
            alert.showAndWait();
        }
    }
    @FXML
    private void btnPlaceOrderPressed() {
        cart.clearCart(); 
        tblMedia.getItems().clear(); 
        costLabel.setText("0 $");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();
    }
}