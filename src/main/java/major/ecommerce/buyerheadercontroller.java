package major.ecommerce;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.SQLException;

public class buyerheadercontroller {
    @FXML
    TextField searchText;

    public void logout(MouseEvent event) throws IOException, SQLException {
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
    public void search(MouseEvent e) throws SQLException, IOException {

        buyer_header h = new buyer_header();
        ProductPage productpage = new ProductPage();
        AnchorPane productpane = new AnchorPane();
        productpane.getChildren().add(productpage.productsBySearch(searchText.getText()));
        productpane.setLayoutX(150);
        productpane.setLayoutY(150);
        Main.root.getChildren().clear();
        Main.root.getChildren().addAll(productpane,h.root);

    }
}
