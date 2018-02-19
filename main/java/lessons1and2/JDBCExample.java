package lessons1and2;

import java.sql.*;
/**
 * Created by Kushn_000 on 01.02.2018.
 */
public class JDBCExample {
    private static final String DB_URL = "jdbc:oracle:thin:@dbofsergey.cbl26hgz4yxf.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASSWORD = "evolution";

    public static void main(String[] args) {
//        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//             Statement statement = connection.createStatement()) {
//
//            statement.execute("INSERT INTO PRODUCT2 VALUES (1, 'toy', 'for children', 60)");
//            statement.execute("INSERT INTO PRODUCT2 VALUES (2, 'toy2', 'for children', 50)");
//            statement.execute("INSERT INTO PRODUCT2 VALUES (3, 'toy3', 'for children', 30)");
//            statement.execute("INSERT INTO PRODUCT2 VALUES (4, 'toy4', 'for children', 110)");
//            statement.execute("UPDATE PRODUCT2 SET NAME = 'toy1' WHERE ID = 1");
//
//        } catch (SQLException e) {
//            System.err.println("Something went wrong");
//            e.printStackTrace();
//        }

//        geyAllProducts();
//        System.out.println();
//        getProductsByPrice();
//        System.out.println();
//        getProductsByDescription();

        saveProduct();
        System.out.println();
        deleteProducts();

    }

//    public static void geyAllProducts() {
//        method("SELECT * FROM PRODUCT");
//    }
//
//    public static void getProductsByPrice() {
//        method("SELECT * FROM PRODUCT WHERE PRICE <= 100");
//    }
//
//    public static void getProductsByDescription() {
//        method("SELECT * FROM PRODUCT WHERE NVL(length(DESCRIPTION),0) > 50");
//    }

    public static void saveProduct() {
        method("INSERT INTO PRODUCT VALUES (999, 'toy', 'for children', 60)");
    }

    public static void deleteProducts() {
        method("DELETE FROM PRODUCT WHERE NAME = 'toy'");
    }

    public static void method(String string) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute(string);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }
}


//"SELECT * FROM PRODUCT"
//"SELECT * FROM PRODUCT WHERE PRICE <= 100"
//"SELECT * FROM PRODUCT WHERE NVL(length(DESCRIPTION),0) > 50"

//statement.execute("INSERT INTO PRODUCT VALUES (10, 'toy10', 'for children00000', 110)");
//statement.execute("UPDATE PRODUCT SET NAME = 'toy1' WHERE ID = 1");

//statement.execute("CREATE TABLE PRODUCT (ID NUMBER NOT NULL, CONSTRAINT PRODUCT " +
//"PRIMARY KEY (ID), NAME VARCHAR (20) NOT NULL, DESCRIPTION BLOB, PRICE NUMBER NOT NULL)");

//try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//        Statement statement = connection.createStatement()) {
//
//        } catch (SQLException e) {
//        System.err.println("Something went wrong");
//        e.printStackTrace();
//        }

//try (ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT WHERE PRICE <= 100")){
