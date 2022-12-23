package major.ecommerce;

        import javafx.fxml.FXMLLoader;
        import javafx.scene.layout.AnchorPane;

        import java.io.IOException;

public class seller_header {
    public AnchorPane root;
    seller_header() throws IOException {
        root = FXMLLoader.load(getClass().getResource("seller_header.fxml"));
    }
}
