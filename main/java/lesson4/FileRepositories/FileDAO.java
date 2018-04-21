package lesson4.FileRepositories;

import java.sql.*;

/**
 * Created by Kushn_000 on 13.04.2018.
 */
public class FileDAO {

    private static final String DB_URL = "jdbc:oracle:thin:@dbofsergey.cbl26hgz4yxf.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASSWORD = "evolution";

    public void save(File file) {
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FILE_TABLE VALUES (?, ?, ?, ?)")) {
//            preparedStatement.setLong(1, file.getId());
//            preparedStatement.setString(2, file.getName());
//            preparedStatement.setString(3, file.getFormat());
//            preparedStatement.setLong(4, file.getSize());
//            int res = preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            System.err.println("Something went wrong");
//            e.printStackTrace();
//        }
    }

    public void delete() {

    }

    public void update() {

    }

    public void findById() {

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

}


//    String sqlQuery1 = "INSERT INTO STORAGE_ONE VALUES (?, ?, ?, ?)";
//    String sqlQuery2 = "INSERT INTO STORAGE_TWO VALUES (?, ?, ?, ?)";
//
//        if (storage.getId() == 201){
//        saveIntoTable(file, sqlQuery1);
//    }else {
//        saveIntoTable(file, sqlQuery2);
//    }

//    private void saveIntoTable(File file, String sqlQuery){}



