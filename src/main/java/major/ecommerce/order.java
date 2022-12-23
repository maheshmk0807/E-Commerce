package major.ecommerce;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class order {

    void placeOrder(String productID) throws SQLException {
        ResultSet res = Main.connection.executeMyQuery("SELECT MAX(orderID) as orderID from orders");
        int orderID=1;
        if(res.next())
        {
            orderID=res.getInt("orderID")+1;
        }
        Timestamp date = new Timestamp(System.currentTimeMillis());
        String query = String.format("INSERT INTO orders values(%s,%s,'%s','%s')",orderID,productID,Main.CEID,date);
        int result = Main.connection.executeMyUpdate(query);
        if(result>0)
        {
            System.out.println("Order Placed");
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Order Status");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.setContentText("Order placed successfully !");
            dialog.showAndWait();
        }
        else {
            System.out.println("Order not placed");
        }

    }
}
