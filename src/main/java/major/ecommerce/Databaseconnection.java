package major.ecommerce;

import java.sql.*;
public class Databaseconnection {
    Connection con = null;
    String Url = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
    String UserName = "root";
    String Password = "root";

    Databaseconnection() throws SQLException {
        con = DriverManager.getConnection(Url,UserName,Password);
        if(con!=null)
            System.out.println("Connection to database successful !");
        else
            System.out.println("Connection to database Failed !");
    }

    public ResultSet executeMyQuery(String query) throws SQLException {
        ResultSet result = null;
        try {

            Statement statement = con.createStatement();
            result = statement.executeQuery(query);

            // ResultSet is inbuilt datatype in mysql to store query result
            // here executeQuery is inbuilt function

            return result;
        } catch (Exception e){  //if wrong input is given
            e.printStackTrace(); //print error but don't break program
        }
        return result;
    }
    public int executeMyUpdate(String query) throws SQLException {
        int rows_affected = 0;

        try{
            Statement statement = con.createStatement();
            rows_affected = statement.executeUpdate(query);

            //Returns rows affected
            // here executeUpdate is inbuilt function

            return rows_affected;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rows_affected;
    }
}
