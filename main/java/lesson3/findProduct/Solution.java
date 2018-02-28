


package lesson3.findProduct;

import lesson3.product.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kushn_000 on 20.02.2018.
 */
public class Solution {
    private static final String DB_URL = "jdbc:oracle:thin:@dbofsergey.cbl26hgz4yxf.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASSWORD = "evolution";

    public Map findProductsByPrice(int price, int delta) {
        int min = price - delta;
        int max = price + delta;
        Map<String, Product> productMap = new HashMap<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT " +
                     "WHERE PRICE > ? AND PRICE < ?")) {
            preparedStatement.setInt(1, min);
            preparedStatement.setInt(2, max);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4));
                productMap.put(resultSet.getString(2), product);
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return productMap;
    }

    public Map findProductsByName(String word) throws Exception {
        if (stringValidate(word)){
            throw new Exception("String " + word + "is wrong");
        }
        Map<String, Product> productMap = new HashMap<>();
        for (long l : findAndMappingId(readingAndMappingDB(), word)) {
            findAndMappingProduct(l, productMap);
        }
        return productMap;
    }

    public Map findProductWithEmptyDescription() {
        Map<String, Product> productMap = new HashMap<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT WHERE DESCRIPTION IS NULL ");
            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4));
                productMap.put(resultSet.getString(2), product);
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return productMap;
    }

    private boolean stringValidate(String word) {
        String[] strings = word.split(" ");
        if (strings.length > 1){
            return false;
        }
        char[] chars = word.toCharArray();
        if (chars.length < 4){
            return false;
        }
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private Map<String, Product> readingAndMappingDB() {
        Map<String, Product> productMap = new HashMap<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT");
            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4));
                productMap.put(resultSet.getString(2), product);
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return productMap;
    }

    private ArrayList<Long> findAndMappingId(Map<String, Product> productMap, String word) {
        ArrayList idAL = new ArrayList();
        for (Product product : productMap.values()) {
            if (product.getName().contains(word)) {
                idAL.add(product.getId());
            }
        }
        return idAL;
    }

    private void findAndMappingProduct(long l, Map<String, Product> productMap) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE  " +
                     "ID = ?")) {
            preparedStatement.setLong(1, l);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4));
                productMap.put(resultSet.getString(2), product);
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
















