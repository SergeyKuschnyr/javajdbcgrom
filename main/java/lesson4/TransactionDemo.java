


package lesson4;

//import lesson3.product.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kushn_000 on 10.04.2018.
 */
public class TransactionDemo {
    private static final String DB_URL = "jdbc:oracle:thin:@dbofsergey.cbl26hgz4yxf.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASSWORD = "evolution";

    public static void main(String[] args) {
        Product product1 = new Product(22, "qwerty", "asdfgh", 12345);
        Product product2 = new Product(33, "qwerty2", "asdfgh2", 12345);
        Product product3 = new Product(44, "qwerty3", "asdfgh3", 12345);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        save(products);
    }

    private static void save(List<Product> products) {
        try (Connection connection = getConnection()) {
            saveList(products, connection);
        } catch (SQLException e) {
            System.err.println("something went wrong");
            e.printStackTrace();
        }
    }

    private static void saveList(List<Product> products, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUCT VALUES (?, ?, ?, ?)")) {

            connection.setAutoCommit(false);

            for (Product product : products) {
                preparedStatement.setLong(1, product.getId());
                preparedStatement.setString(2, product.getName());
                preparedStatement.setString(3, product.getDescription());
                preparedStatement.setInt(4, product.getPrice());

                int res = preparedStatement.executeUpdate();
                System.out.println("save was finished with result " + res);
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
