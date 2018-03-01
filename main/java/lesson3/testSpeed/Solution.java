package lesson3.testSpeed;

import java.sql.*;


/**
 * Created by Kushn_000 on 22.02.2018.
 */
public class Solution {

    private static final String DB_URL = "jdbc:oracle:thin:@dbofsergey.cbl26hgz4yxf.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASSWORD = "evolution";

    public long testSavePerformance() throws SQLException {

        // 121558

        long timeStart = System.currentTimeMillis();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("INSERT INTO TEST_SPEED VALUES (?, 'toy', 60)")) {

            int i = 2;
            while (i < 1002) {
                preparedStatement.setInt(1, i);
                preparedStatement.executeUpdate();
                i++;
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        long timeSpent = System.currentTimeMillis();
        return timeSpent - timeStart;
    }

    public long testDeleteByIdPerformance() throws SQLException {

        // 122464

        long timeStart = System.currentTimeMillis();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("DELETE FROM TEST_SPEED WHERE ID = ?")) {

            int i = 2;
            while (i < 1002) {
                preparedStatement.setInt(1, i);
                preparedStatement.executeUpdate();
                i++;
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        long timeSpent = System.currentTimeMillis();
        return timeSpent - timeStart;
    }

    public long testDeletePerformance() {

        // 2536

        long timeStart = System.currentTimeMillis();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DELETE FROM TEST_SPEED WHERE ID > 1 AND ID < 1002");

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        long timeSpent = System.currentTimeMillis();
        return timeSpent - timeStart;
    }

    public long testSelectByIdPerformance() {

        // 120961

        long timeStart = System.currentTimeMillis();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("SELECT * FROM TEST_SPEED WHERE ID = ?")) {

            int i = 2;
            while (i < 1002) {
                preparedStatement.setInt(1, i);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    System.out.println(resultSet.getInt(1));
                }
                i++;
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        long timeSpent = System.currentTimeMillis();
        return timeSpent - timeStart;
    }

    public long testSelectPerformance() {

        // 2656

        long timeStart = System.currentTimeMillis();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeQuery("SELECT * FROM TEST_SPEED WHERE ID > 1 AND ID < 1002");

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        long timeSpent = System.currentTimeMillis();
        return timeSpent - timeStart;
    }
}



