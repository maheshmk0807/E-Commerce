package major.ecommerce;

import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class BuyerPage {

    BuyerPage() throws IOException, SQLException {

        buyer_header headerb = new buyer_header();
        ProductPage productpage = new ProductPage();
        AnchorPane productpane = new AnchorPane();
        productpane.getChildren().add(productpage.products());
        productpane.setLayoutX(150);
        productpane.setLayoutY(150);

        Main.root.getChildren().clear();
        Main.root.getChildren().addAll(headerb.root,productpane);
    }
}
