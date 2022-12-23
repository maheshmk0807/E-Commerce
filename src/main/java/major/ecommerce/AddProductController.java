package major.ecommerce;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
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
        String query = String.format("Insert into product values(%s,'%s',%s,'%s')",productID,productname.getText(),productprice.getText(),Main.CEID);
        int response = Main.connection.executeMyUpdate(query);
        if(response>0)
        {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Success");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.setContentText("Product added successfully !");
            dialog.showAndWait();
        }
        else
        {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Failed");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.setContentText("Product not added please check format !");
            dialog.showAndWait();
        }
    }
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
