package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import hust.soict.hedspi.aims.cart.Cart;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import java.util.ArrayList;
public class ViewStoreController {

    private Store store;
    private Cart cart;
    
    public ViewStoreController(Store store, Cart cart) {
    	this.store = store;
        this.cart = cart;
    }

    @FXML
    private GridPane gridPane;

    @FXML
    public void initialize() {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml";
        if (store == null || store.getMediaInStore() == null) {
            System.err.println("Store hoặc các mục trong store là null. Không thể điền vào view.");
            return;
        }

        ArrayList<Media> itemsInStore = store.getMediaInStore();
        if (itemsInStore.isEmpty()) {
            System.out.println("Cửa hàng hiện không có sản phẩm nào.");
            return;
        }
        
        int column = 0;
        int row = 1;
        for (int i = 0; i < store.getMediaInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));

                ItemController itemController = new ItemController(cart);
                fxmlLoader.setController(itemController);

                AnchorPane anchorPane = new AnchorPane();
                anchorPane = fxmlLoader.load();

                itemController.setData(store.getMediaInStore().get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    private void btnViewCartPressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
            System.out.println(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml"));
            FXMLLoader loader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            loader.setController(new CartController(store, cart));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi Điều Hướng");
            alert.setHeaderText("Không thể tải màn hình giỏ hàng.");
            alert.setContentText("Vui lòng kiểm tra đường dẫn file FXML hoặc liên hệ hỗ trợ.\nChi tiết lỗi: " + e.getMessage());
            alert.showAndWait();
        } catch (NullPointerException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi File FXML");
            alert.setHeaderText("Không tìm thấy file Cart.fxml.");
            alert.setContentText("Vui lòng kiểm tra đường dẫn: /hust/soict/hedspi/aims/screen/customer/view/Cart.fxml\nChi tiết lỗi: " + e.getMessage());
            alert.showAndWait();
        }
    }

}
