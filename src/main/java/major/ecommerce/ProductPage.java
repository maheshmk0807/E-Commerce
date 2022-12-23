package major.ecommerce;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import java.sql.ResultSet;
import java.sql.SQLException;


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
                        Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("Login needed");
                        ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.setContentText("Please Login to buy!");
                        dialog.showAndWait();
                    }
                    else {
                        order o = new order();
                        try {
                            o.placeOrder(productID.getText());
                        } catch (SQLException e) {
                           e.getStackTrace();
                        }
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
    ListView productsBySearch(String searchText) throws SQLException {
        products= new ListView<>();
        ObservableList<HBox> productList = FXCollections.observableArrayList();
        ResultSet res = Main.connection.executeMyQuery("Select * from product");
        while(res.next())
        {
            if(!(res.getString("productName").toLowerCase()).contains(searchText.toLowerCase()))
                continue;
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

                        Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("Login needed");
                        ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.setContentText("Please Login to buy!");
                        dialog.showAndWait();
                    }
                    else {
                        order o = new order();
                        try {
                            o.placeOrder(productID.getText());
                        } catch (SQLException e) {
                            e.getStackTrace();
                        }
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

    ListView sellerproducts(String seller) throws SQLException {
        products= new ListView<>();
        ObservableList<HBox> productList = FXCollections.observableArrayList();
        ResultSet res = Main.connection.executeMyQuery("Select * from product where sellerID = '" + seller + "'");
        int count=0;
        while(res.next())
        {
            count++;
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
        if(count==0)
        {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("No Products");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.setContentText("You don't have any product listed.");
            dialog.showAndWait();
        }
        products.setItems(productList);
        return products;
    }
}
