package jdbctests.day5;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DButilPractice {


    @Test
    public void test1() {

        //create connections
        DBUtils.createConnection();

        String query = "SELECT FIRST_NAME, LAST_NAME, SALARY, JOB_ID from EMPLOYEES where ROWNUM < 6";

        List<Map<String, Object>> queryData = DBUtils.getQueryResultMap(query);

        //print the result
        for (Map<String, Object> row : queryData) {
            System.out.println(row.toString());
        }


        //close the connection
        DBUtils.destroy();

    }

    @Test
    public void test2() {

        //create connections
        DBUtils.createConnection();

        String query = "SELECT FIRST_NAME, LAST_NAME, SALARY, JOB_ID from EMPLOYEES where ROWNUM < 2";

        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        //print the result
        System.out.println(rowMap.toString());

        //close the connection
        DBUtils.destroy();

    }


}
