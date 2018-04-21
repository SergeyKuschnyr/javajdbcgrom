package lesson4.FileRepositories;

import java.sql.*;

/**
 * Created by Kushn_000 on 12.04.2018.
 */
public class Controller {

    FileDAO fileDAO = new FileDAO();

    private static final String DB_URL = "jdbc:oracle:thin:@dbofsergey.cbl26hgz4yxf.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASSWORD = "evolution";

    public void put(File file, Storage storage) throws Exception {
        validate(file, storage);
        fileDAO.save(file);
    }

    public void delete(Storage storage, File file) {
        //0. вх. значние не нуль
        // дальше одной транзакцией
        //1. есть ли хранилище ?
        //2. есть ли файл ?
        //3. удаляем

    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {
        //0. вх. значние не нуль
        // дальше одной транзакцией
        //1. есть ли место в хранилище ?
        //2. мапим запись в файл
        //3. используем delete method
        //4. используем put method

    }

    public void transferAll(Storage storageFrom, Storage storageTo) {
        //0. вх. значние не нуль
        // дальше одной транзакцией
        //1. существую ли стореджи ?
        //2. есть ли место в хранилище ?
        //3. мапим все
        //4. удаляем все
        //5. сохраняем используя put method

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    private void validate(File file, Storage storage) throws Exception {
        //0. вх. значения не нуль                               +
        //   дальше одной транзакцией
        //2. проверяем формат файла (хранилище)                 +
        //3. есть ли место в хранилище (хранилище) ?            +
        //4. проверка на наличие такого же файла (хранилище)

        if (file == null || storage == null) {
            throw new Exception("You using nullable parameter for validate method");
        }

        String[] fs = storage.getFormatSupported().split(",");
        boolean sameFormat = false;
        for (String fSupported : fs) {
            if (fSupported.equals(file.getFormat())) {
                sameFormat = true;
                break;
            }
        }
        if (!sameFormat) {
            throw new Exception("You can't save file: " + file.getName() + "." + file.getFormat() +
                    " in storage with id: " + storage.getId() + ". Forbid to save file that format In this storage");
        }

        ResultSet resultSet = null;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery("SELECT SUM(FILE_SIZE) FROM FILE_TABLE");
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        if (file.getSize() > storage.getStorageSize() - resultSet.getLong("SUM(FILE_SIZE)")) {
            throw new Exception("In storage with id: " + storage.getId() + "don't enough the space " +
                    "for file " + file.getName() + "." + file.getFormat());
        }

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            boolean sameId = false;
            resultSet = statement.executeQuery("SELECT COUNT (ID) FROM FILE_TABLE");
            int numberOfRecords = (int)resultSet.getLong("COUNT(ID)");
            resultSet = statement.executeQuery("SELECT ID FROM FILE_TABLE");
            for (int i = 0; i < numberOfRecords; i++){
                if(resultSet.getLong("FILE_ID") == file.getId()){
                    sameId = true;
                    break;
                }
                resultSet.next();
            }
            if (!sameId){
                new Exception("The file " + file.getName() + "." + file.getFormat() +
                        "allready exist in storage with ID: " + storage.getId());
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        if (file.getSize() > storage.getStorageSize() - resultSet.getLong("SUM(FILE_SIZE)")) {
            throw new Exception("In storage with id: " + storage.getId() + "don't enough the space " +
                    "for file " + file.getName() + "." + file.getFormat());
        }
    }
}




//        int nullIndex = -1;
//        for (File file1 : storage.getFiles()) {
//            if (file1 == null) {
//                nullIndex++;
//                break;
//            }
//        }
//        if (nullIndex == -1) {
//            throw new Exception("No place in DB");
//        }


//        if (storage != null || file != null) {
//            throw new Exception("input value is nullable");
//        }

//        boolean trueFormat = false;
//        for (String s : storage.getFormatsSupported()) {
//            if (s.equals(file.getFormat())) {
//                trueFormat = true;
//                break;
//            }
//        }
//        if (trueFormat == false) {
//            throw new Exception("File format is wrong");
//        }


//try (Connection connection = getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUCT VALUES (?, ?, ?, ?)")) {
//
//        if (file != null) {
//        throw new Exception("input value is nullable");
//        }
//
//
//
//        boolean trueFormat = false;
//        for (String s : storage.getFormatsSupported()) {
//        if (s.equals(file.getFormat())) {
//        trueFormat = true;
//        break;
//        }
//        }
//        if (trueFormat == false) {
//        throw new Exception("File format is wrong");
//        }
//
//        preparedStatement.setLong(1, product.getId());
//        preparedStatement.setString(2, product.getName());
//        preparedStatement.setString(3, product.getDescription());
//        preparedStatement.setInt(4, product.getPrice());
//        int res = preparedStatement.executeUpdate();
//        System.out.println("save was finished with result " + res);
//        } catch (SQLException e) {
//        System.err.println("Something went wrong");
//        e.printStackTrace();
//        }
//        return product;
//
//        long amount = 0;
//        for (File file1 : storage.getFiles()) {
//        amount += file1.getSize();
//        }
//        if (file.getSize() > storage.getStorageSize() - amount) {
//        throw new Exception("don't enough place in storage");
//        }
//
//        boolean sameFile = false;
//        for (File file1 : storage.getFiles()) {
//        if (file1.equals(file)) {
//        sameFile = true;
//        break;
//        }
//        }
//        if (sameFile == false) {
//        throw new Exception("That file already exist");
//        }
//
//        storage.getFiles()[nullIndex] = file;


//            resultSet.last();
//            int rowNumber = resultSet.getRow();
//            resultSet.beforeFirst();