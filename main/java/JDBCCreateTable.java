


import java.sql.*;

/**
 * Created by Kushn_000 on 01.02.2018.
 */
public class JDBCCreateTable {
    private static final String DB_URL = "jdbc:oracle:thin:@dbofsergey.cbl26hgz4yxf.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASSWORD = "evolution";

    public static void main(String[] args) {
        increasePrice();
        changeDescription();
    }

        public static void increasePrice(){
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement()) {
                statement.execute("UPDATE PRODUCT SET PRICE = (PRICE + 100) WHERE PRICE < 970");
            } catch (SQLException e) {
                System.err.println("Something went wrong");
                e.printStackTrace();
            }
    }

    public static void changeDescription() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT WHERE NVL(length(DESCRIPTION),0) > 100")) {
                if (resultSet.last()){
//                    System.out.println(resultSet.getRow());
//                    System.out.println(resultSet.getInt(1));
                    resultSet.deleteRow();
                }
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }
}
