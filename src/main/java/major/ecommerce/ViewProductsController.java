package major.ecommerce;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ViewProductsController {
    public void logout (MouseEvent e) throws IOException {
        AnchorPane loginpage = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Main.root.getChildren().clear();
        Main.root.getChildren().add(loginpage);

    }
}
