package major.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class HeaderController {

    @FXML

    Button gotologinpagebutton;

    @FXML
    TextField searchText;
    @FXML
    public void login(MouseEvent event) throws IOException{
        AnchorPane loginpage = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Main.root.getChildren().add(loginpage);
    }
    public void search(MouseEvent e) throws SQLException, IOException {

        Header h = new Header();
        ProductPage productpage = new ProductPage();
        AnchorPane productpane = new AnchorPane();
        productpane.getChildren().add(productpage.productsBySearch(searchText.getText()));
        productpane.setLayoutX(150);
        productpane.setLayoutY(150);

        Main.root.getChildren().clear();
        Main.root.getChildren().addAll(productpane,h.root);

    }


}
