package major.ecommerce;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import java.sql.ResultSet;
import java.sql.SQLException;

public class myProducts {
    ListView<HBox> products;
    ListView products() throws SQLException {
        products= new ListView<>();
        ObservableList<HBox> productList = FXCollections.observableArrayList();
        ResultSet res = Main.connection.executeMyQuery("Select * from product where sellerID=" + "'" + Main.CEID +"';");
        System.out.println("Select * from product where sellerID=" + "'" + Main.CEID +"';");
        while(res.next())
        {
            Label productID = new Label();
            Label name = new Label();
            Label price = new Label();
            HBox productdetails = new HBox();
            productdetails.setMaxSize(500,500);
            productID.setMinWidth(20);
            name.setMinWidth(80);
            price.setMinWidth(75);
            productID.setText(res.getString("productID"));
            name.setText(res.getString("productName"));
            price.setText(res.getString("price"));
            productdetails.getChildren().addAll(productID,name,price);
            productList.add(productdetails);
        }
        products.setItems(productList);
        return products;

    }
}


//------------------------------VIEW MY PRODUCTS COMPLETED--------------------------------------------------------------
