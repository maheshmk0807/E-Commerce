package major.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.SQLException;
public class SellerMenuController {
    @FXML
    public void addproduct (MouseEvent e) throws IOException {
        AnchorPane sellerpage = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        Main.root.getChildren().clear();
        Main.root.getChildren().addAll(sellerpage);
    }
    @FXML
    public void viewproducts (MouseEvent e) throws IOException, SQLException {
        AnchorPane viewproductspage = FXMLLoader.load(getClass().getResource("viewproducts.fxml"));
        ProductPage productpage = new ProductPage();
        AnchorPane productpane = new AnchorPane();
        productpane.getChildren().add(productpage.sellerproducts(Main.CEID));
        productpane.setLayoutX(150);
        productpane.setLayoutY(150);
        Main.root.getChildren().clear();
        Main.root.getChildren().addAll(productpane,viewproductspage);
    }
    public void deleteproduct (MouseEvent e) throws IOException {
        AnchorPane deleteproductpage = FXMLLoader.load(getClass().getResource("deleteproduct.fxml"));
        Main.root.getChildren().clear();
        Main.root.getChildren().add(deleteproductpage);
    }
    public void logout (MouseEvent e) throws IOException, SQLException {
        Main.CEID="";
        Header header = new Header();
        ProductPage productpageh = new ProductPage();
        AnchorPane productpaneh = new AnchorPane();
        productpaneh.getChildren().add(productpageh.products());
        productpaneh.setLayoutX(150);
        productpaneh.setLayoutY(150);
        Main.root.getChildren().clear();
        Main.root.getChildren().addAll(productpaneh, header.root);
    }
}
