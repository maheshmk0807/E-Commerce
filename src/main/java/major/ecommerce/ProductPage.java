package major.ecommerce;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductPage {
    ListView<HBox> products;

    ListView products() throws SQLException {
        products= new ListView<>();
        ObservableList<HBox> productList = FXCollections.observableArrayList();
        ResultSet res = Main.connection.executeMyQuery("Select * from product");
        while(res.next())
        {
            Label productID = new Label();
            Label name = new Label();
            Label price = new Label();
            Button buy = new Button();
            HBox productdetails = new HBox();

            buy.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(Main.CEID=="")
                    {
                        System.out.println("Please login first !");
                    }
                    else {
                        System.out.println("Buyyyyyyy " + Main.CEID);

                    }

                }
            });

            productdetails.setMaxSize(500,500);

            productID.setMinWidth(20);
            name.setMinWidth(80);
            price.setMinWidth(75);

            buy.setText("BUY");

            productID.setText(res.getString("productID"));
            name.setText(res.getString("productName"));
            price.setText(res.getString("price"));

            productdetails.getChildren().addAll(productID,name,price,buy);
            productList.add(productdetails);
        }

        products.setItems(productList);
        return products;

    }
}
