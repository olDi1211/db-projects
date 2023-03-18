package jdbctests;

import java.sql.*;

public class TestConnection {

    public static void main(String[] args) throws SQLException {

        String dbURL = "jdbc:oracle:thin:@54.210.90.4:1521:XE";
        String dbUserName = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(dbURL,dbUserName,password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from REGIONS");

        //once you setup connection default pointer looks for 0
        //next() --> move pointer to first row
        //resultSet.next();

        //getting information with column name
        //System.out.println("resultSet.getString(\"region_name\") = " + resultSet.getString("region_name"));

        //getting information with column number
        //System.out.println("resultSet.getString(2) = " + resultSet.getString(2));

        //1- Europe
        //2- Americas
        //System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2));

        //move to second row
        //resultSet.next();
        //System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2));

        //move to third row
        //resultSet.next();
        //System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2));

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2));

        }

        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }

}
