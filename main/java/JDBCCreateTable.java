
import java.sql.*;
/**
 * Created by Kushn_000 on 01.02.2018.
 */
public class JDBCCreateTable {
    private static final String DB_URL = "jdbc:oracle:thin:@dbofsergey.cbl26hgz4yxf.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASSWORD = "evolution";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE PRODUCT (ID NUMBER NOT NULL, CONSTRAINT PRODUCT " +
                    "PRIMARY KEY (ID), NAME VARCHAR (20) NOT NULL, DESCRIPTION CLOB, PRICE NUMBER NOT NULL)");

            statement.execute("INSERT INTO PRODUCT VALUES (1, 'toy', 'for children', 60)");
            statement.execute("INSERT INTO PRODUCT VALUES (2, 'toy2', 'for children', 50)");
            statement.execute("INSERT INTO PRODUCT VALUES (3, 'toy3', 'for children', 30)");
            statement.execute("INSERT INTO PRODUCT VALUES (4, 'toy4', 'for children', 110)");
            statement.execute("UPDATE PRODUCT SET NAME = 'toy1' WHERE ID = 1");

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }

        //increasePrice();
//        System.out.println();
//        changeDescription();
    }

//    public static void increasePrice(){
//        method("UPDATE PRODUCT SET PRICE = (PRICE + 100) WHERE PRICE < 970");
//    }
//
//    public static void changeDescription(){
//        method("DELETE FROM PRODUCT WHERE NVL(length(DESCRIPTION),0) > 15");
//    }
//
//    public static void method(String string) {
//        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//             Statement statement = connection.createStatement()) {
//            int res = statement.executeUpdate(string);
//        } catch (SQLException e) {
//            System.err.println("Something went wrong");
//            e.printStackTrace();
//        }
//    }
}
