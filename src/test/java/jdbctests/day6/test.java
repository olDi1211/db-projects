package jdbctests.day6;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {


    String dbURL = "jdbc:oracle:thin:@34.229.255.164:1521:XE";
    String dbUserName = "hr";
    String password = "hr";
    @Test
    public void test1() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL, dbUserName, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES WHERE SALARY = (select max(EMPLOYEES.SALARY) " +
                "from (select * from EMPLOYEES order by SALARY asc) where rownum<3)");

        //in order to get column names we need resultsetmetadata
        ResultSetMetaData rsmd = resultSet.getMetaData();


        System.out.println(rsmd.getColumnCount());
        //how to find many rows we have for a query
        //move to last row
        resultSet.last();

        //get the row count
        int rowCount = resultSet.getRow();
        System.out.println(rowCount);

        //list of maps to keep all information
        List<Map<String,Object>> queryData = new ArrayList<>();

        //number of colums
        int colCount = rsmd.getColumnCount();

        //loop through each row
        while (resultSet.next()){

            Map<String, Object> row = new HashMap<>();

            //some code to fill map dynamically
            for (int i = 1; i <= colCount; i++) {
                row.put(rsmd.getColumnName(i),resultSet.getObject(i));
            }

            //add ready map row to the list
            queryData.add(row);

        }

        //print each row inside the list
        for (Map<String, Object> row : queryData){
            System.out.println(row.toString());
        }


        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
