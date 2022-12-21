package major.ecommerce;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ViewProductsController {

    public void logout (MouseEvent e) throws IOException {
        AnchorPane homepage = FXMLLoader.load(getClass().getResource("Header.fxml"));
        Main.root.getChildren().add(homepage);
    }
}
