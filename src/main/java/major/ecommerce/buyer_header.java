package major.ecommerce;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class buyer_header {
    public AnchorPane root;
    buyer_header() throws IOException {
        root = FXMLLoader.load(getClass().getResource("buyer_header.fxml"));
    }
}
