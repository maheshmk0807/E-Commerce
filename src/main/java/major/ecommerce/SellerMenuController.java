package major.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class SellerMenuController {

    @FXML

    public void addproduct (MouseEvent e) throws IOException {
        seller_header headers = new seller_header();
        AnchorPane sellerpage = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        Main.root.getChildren().clear();
        Main.root.getChildren().addAll(sellerpage);
    }

    @FXML
    public void viewproducts (MouseEvent e) throws IOException {
        AnchorPane viewproductspage = FXMLLoader.load(getClass().getResource("viewproducts.fxml"));
        Main.root.getChildren().clear();
        Main.root.getChildren().add(viewproductspage);

    }
    public void deleteproduct (MouseEvent e) throws IOException {
        AnchorPane deleteproductpage = FXMLLoader.load(getClass().getResource("deleteproduct.fxml"));
        Main.root.getChildren().clear();
        Main.root.getChildren().add(deleteproductpage);
    }
    public void logout (MouseEvent e) throws IOException {
        AnchorPane loginpage = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Main.root.getChildren().clear();
        Main.root.getChildren().add(loginpage);
    }
}
