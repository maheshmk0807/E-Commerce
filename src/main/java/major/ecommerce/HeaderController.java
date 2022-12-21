package major.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HeaderController {

    @FXML

    Button gotologinpagebutton;

    @FXML
    public void login(MouseEvent event) throws IOException{
        AnchorPane loginpage = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Main.root.getChildren().add(loginpage);
    }


}
