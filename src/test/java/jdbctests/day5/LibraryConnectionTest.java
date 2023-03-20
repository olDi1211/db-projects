package jdbctests.day5;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryConnectionTest {

    String dbURL = "jdbc:mysql://34.230.35.214:3306/library1";
    String dbUserName = "library1_client";
    String password = "WVF4NdGXCKHeE6VQ";

    @Test
    public void test2() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, dbUserName, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

        resultSet.next();

        System.out.println(resultSet.getString(2));

        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }


}
