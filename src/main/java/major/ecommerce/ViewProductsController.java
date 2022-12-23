package major.ecommerce;
//used
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.SQLException;

public class ViewProductsController {
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
