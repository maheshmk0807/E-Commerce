package major.ecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddProductController {

    @FXML
    TextField productname,productprice,sellerid;

    @FXML

    public void addproduct(MouseEvent e) throws SQLException {
        //productID = MAX IN DB TILL NOW
        int productID =1;
        ResultSet res1 = Main.connection.executeMyQuery("Select max(productid) as productID from product");
        if(res1.next())
        {
            productID=res1.getInt("productID")+1;
        }


        String query = String.format("Insert into product values(%s,'%s',%s,'%s')",productID,productname.getText(),productprice.getText(),LoginPageController.currentUser);

        int response = Main.connection.executeMyUpdate(query);
        if(response>0)
        {
            System.out.println("Product Added");
        }
        else
        {
            System.out.println("product NOT added");
        }
    }
    public void logout (MouseEvent e) throws IOException {
        AnchorPane homepage = FXMLLoader.load(getClass().getResource("Header.fxml"));
        Main.root.getChildren().add(homepage);
    }
}
