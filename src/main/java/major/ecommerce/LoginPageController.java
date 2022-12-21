package major.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
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

    public static String currentUser;
    @FXML
    public void login (MouseEvent e) throws SQLException, IOException {
        String query = String.format("Select * from user where emailID = '%s' AND pass ='%s'",email.getText(),password.getText());
        ResultSet result = Main.connection.executeMyQuery(query);
        if(result.next())
        {
            String usertype = result.getString("userType");
            if(usertype.equals("SELLER")) //OPEN SELLER PAGE
            {
                AnchorPane sellerpage = FXMLLoader.load(getClass().getResource("SellerMenu.fxml"));
                Main.root.getChildren().add(sellerpage);
                currentUser= email.getText();
            }
            else  //OPEN BUYER PAGE
            {

            }
            System.out.println("User Valid");
        }
        else {
            System.out.println("USER NOT VALID");
        }
    }
}
