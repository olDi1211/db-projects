package jdbctests.day6;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class test1 {
    String dbURL = "jdbc:oracle:thin:@54.210.90.4:1521:XE";
    String dbUserName = "hr";
    String password = "hr";

    @Test
    public void test23() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, dbUserName, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT FIRST_NAME, LAST_NAME from EMPLOYEES");

        //in order to get column names we need resultsetmetadata
        ResultSetMetaData rsmd = resultSet.getMetaData();

        //list of maps to keep all information
        List<Map<String, Object>> queryData = new ArrayList<>();

        //number of colums
        int colCount = rsmd.getColumnCount();

        //loop through each row
        while (resultSet.next()) {

            Map<String, Object> row = new HashMap<>();

            //some code to fill map dynamically
            for (int i = 1; i <= colCount; i++) {
                row.put(rsmd.getColumnName(i), resultSet.getObject(i));
            }

            //add ready map row to the list
            queryData.add(row);

        }

        //print each row inside the list
        for (Map<String, Object> row : queryData) {
            System.out.println(row.toString());
        }


        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
