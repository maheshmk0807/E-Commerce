package major.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginPageController {
    @FXML
    TextField email;
    @FXML
    TextField password;
    @FXML
    public void login (MouseEvent e) throws SQLException, IOException {
        String query = String.format("Select * from user where emailID = '%s' AND pass ='%s'",email.getText(),password.getText());
        ResultSet result = Main.connection.executeMyQuery(query);
        if(result.next())
        {
            Main.CEID=result.getString("emailID");
            String usertype = result.getString("userType");
            if(usertype.equals("SELLER")) //OPEN SELLER PAGE
            {
                AnchorPane sellerpage = FXMLLoader.load(getClass().getResource("SellerMenu.fxml"));
                Main.root.getChildren().add(sellerpage);
            }
            else  //OPEN BUYER PAGE
            {
                AnchorPane bh = FXMLLoader.load(getClass().getResource("buyer_header.fxml"));
                ProductPage productpage = new ProductPage();
                AnchorPane productpane = new AnchorPane();
                productpane.getChildren().add(productpage.products());
                productpane.setLayoutX(150);
                productpane.setLayoutY(150);
                Main.root.getChildren().clear();
                Main.root.getChildren().addAll(productpane,bh);
            }
        }
        else {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Invalid Credentials");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.setContentText("Please check Username/Password and try again.");
            dialog.showAndWait();
        }
    }
}
