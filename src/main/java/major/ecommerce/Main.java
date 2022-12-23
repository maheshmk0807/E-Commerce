package major.ecommerce;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    public static Databaseconnection connection;
    public static Group root;
    public static String CEID; //Cuerrent User Email ID
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        CEID = "";
        connection = new Databaseconnection();
        root = new Group();
        Image image = new Image(getClass().getResourceAsStream("icon.jpg"));
        stage.getIcons().add(image);
        Header header = new Header();
        ProductPage productpageh = new ProductPage();
        AnchorPane productpaneh = new AnchorPane();
        productpaneh.getChildren().add(productpageh.products());
        productpaneh.setLayoutX(150);
        productpaneh.setLayoutY(150);
        Main.root.getChildren().clear();
        root.getChildren().addAll(productpaneh, header.root);
        stage.setTitle("E Commerce");
        Scene scene = new Scene(root, 1080, 720);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> // after clicking on close button
        {
            try {

                connection.con.close();//close connection to database
                System.out.println("Connection Closed");

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    public static void main(String[] args) {
        launch();
    }
}