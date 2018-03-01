package lesson3.findProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Kushn_000 on 21.02.2018.
 */
public class SolutionDemo {
    private static final String DB_URL = "jdbc:oracle:thin:@dbofsergey.cbl26hgz4yxf.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASSWORD = "evolution";

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findProductsByPrice(50, 20));

//        System.out.println(solution.findProductWithEmptyDescription());

        try {
            System.out.println(solution.findProductsByName("toy"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        testSpeed();
    }

    public static void testSpeed() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            int i = statement.executeUpdate("CREATE TABLE TEST_SPEED (ID NUMBER NOT NULL, CONSTRAINT TEST_SPEED " +
                    "PRIMARY KEY (ID), SOME_STRING VARCHAR (20) NOT NULL, SOME_NUMBER NUMBER NOT NULL )");
            System.out.println("i: " + i);
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}

























