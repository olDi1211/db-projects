package jdbctests.day5;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbc_examples {

    String dbURL = "jdbc:oracle:thin:@54.210.90.4:1521:XE";
    String dbUserName = "hr";
    String password = "hr";

    @Test
    public void test1() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL, dbUserName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from DEPARTMENTS");

        //move to first row
        //resultSet.next();

        //System.out.println(resultSet.getString(2));
        //display departments table in 10 - Administration - 200 - 1700 format

        //code for iterating for each row
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " +
                    resultSet.getString(3) + " - " + resultSet.getInt(4));
        }
        System.out.println("-------------------------------------------------------------------------------------");

        resultSet = statement.executeQuery("SELECT * FROM REGIONS");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        }

        //close connection
        resultSet.close();
        statement.close();
        connection.close();


    }


    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL, dbUserName, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * from EMPLOYEES");

        //how to find many rows we have for a query
        //move to last row
        resultSet.last();

        //get the row count
        int rowCount = resultSet.getRow();
        System.out.println(rowCount);

        //to move before first row after we use .last method
        resultSet.beforeFirst();

        //print all second column information
        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }


        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }


    @Test
    public void test3() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL, dbUserName, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * from DEPARTMENTS");

        //get the database related data inside the dbMetadata object
        DatabaseMetaData dbMetadata = connection.getMetaData();

        System.out.println("dbMetadata.getUserName() = " + dbMetadata.getUserName());
        System.out.println("dbMetadata.getDatabaseProductName() = " + dbMetadata.getDatabaseProductName());
        System.out.println("dbMetadata.getDatabaseProductVersion() = " + dbMetadata.getDatabaseProductVersion());
        System.out.println("dbMetadata.getDriverName() = " + dbMetadata.getDriverName());
        System.out.println("dbMetadata.getDriverVersion() = " + dbMetadata.getDriverVersion());


        //close connection
        resultSet.close();
        statement.close();
        connection.close();

    }


}
