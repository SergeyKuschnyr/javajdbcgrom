


import java.io.StringReader;
import java.sql.*;
import java.util.Arrays;

/**
 * Created by Kushn_000 on 01.02.2018.
 */
public class JDBCCreateTable {
    private static final String DB_URL = "jdbc:oracle:thin:@dbofsergey.cbl26hgz4yxf.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASSWORD = "evolution";

    public static void main(String[] args) {

        //increasePrice();
        try {
            changeDescription();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void increasePrice() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("UPDATE PRODUCT SET PRICE = (PRICE + 100) WHERE PRICE < 970");
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public static void changeDescription() throws Exception {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT WHERE NVL(length(DESCRIPTION),0) > 15")) {
                if (resultSet.first()) {
                    resultSet.beforeFirst();
                    while (resultSet.next()) {
                        String s = resultSet.getString(3);
                        String[] strings = s.split(".");
                        deleteLastSentence(strings);
                        resultSet.updateClob(3, new StringReader(Arrays.deepToString(strings)));
                    }
                }
                throw new Exception("Your SQL query nothing return");
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public static void deleteLastSentence(String[] strings) throws Exception {
        if (strings.length > 1) {
            strings[strings.length - 1] = null;
        }
        //throw new Exception("Description has one sentence only");
    }
}



















