package major.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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


        myProducts productpage = new myProducts();
        AnchorPane productpane = new AnchorPane();
        productpane.getChildren().add(productpage.products());
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
    public void logout (MouseEvent e) throws IOException {
        AnchorPane loginpage = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Main.root.getChildren().clear();
        Main.root.getChildren().add(loginpage);
    }
}
