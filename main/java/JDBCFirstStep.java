import java.sql.*;

/**
 * Created by Kushn_000 on 01.02.2018.
 */
public class JDBCFirstStep {
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@dbofsergey.cbl26hgz4yxf.us-east-1.rds.amazonaws.com:1521:ORCL";

    private static final String USER = "main";
    private static final String PASSWORD = "evolution";

    public static void main(String[] args) throws Exception {
        //1. DB Driver (installing & registration in code)
        //2. Create connecting
        //3. Create query/statement
        //4. Execute query/statement
        //5. Work with result
        //6. Close all the connection

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("Class " + JDBC_DRIVER + "not found");
                return;
            }

            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM ORDERS")) {
                while (resultSet.next()) {
                    for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                        System.out.println(resultSet.getString(i));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public static ResultSet jdbcStart() throws Exception {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                throw new Exception("Something went wrong");
            }
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM ORDERS")) {
                return resultSet;
            }
        } catch (SQLException e) {
            throw new Exception("Something went wrong");
        }
    }
}
