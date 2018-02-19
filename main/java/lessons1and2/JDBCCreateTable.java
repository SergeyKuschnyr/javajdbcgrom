package lessons1and2;


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
                while (resultSet.next()) {
                    System.out.println("iteration");
                    String s = resultSet.getString(3);
                    System.out.println(s);
                    String[] strings = s.split("\\.");
                    System.out.println(strings.length);
                    int i = resultSet.getInt(1);
                    String[] str = deleteLastSentence(strings);
                    if (str != null) {
                        String strg = String.join(".", str);
                        //resultSet.updateClob(3, new StringReader(strg));
                        statement.executeUpdate("UPDATE PRODUCT SET DESCRIPTION = 'strg' WHERE ID = i");
                    } else
                        throw new Exception("Description has one sentence only");
                }
                throw new Exception("Your SQL query nothing return");
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public static String[] deleteLastSentence(String[] strings) {
        if (strings.length > 1) {
            String[] strings1 = new String[strings.length - 1];
            for (int i = 0; i < strings1.length; i++) {
                strings1[i] = strings[i];
            }
            return strings1;
        }
        return null;
    }
}


//ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE


















