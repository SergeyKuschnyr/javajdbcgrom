package lesson4.FileRepositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Kushn_000 on 15.04.2018.
 */
public class Demo {
    File file1 = new File(101, "File1", "txt", 500);
    File file2 = new File(102, "File2", "jpg", 500);
    File file3 = new File(103, "File3", "exe", 500);
    File file4 = new File(104, "File4", "txt", 500);
    File file5 = new File(105, "File5", "jpg", 500);
    File file6 = new File(106, "File6", "exe", 500);
    File file7 = new File(107, "File7", "txt", 500);
    File file8 = new File(108, "File8", "pdf", 500);


    Storage storage1 = new Storage(201, "txt, exe, jpg", "Ukraine", 50000);
    Storage storage2 = new Storage(202, "txt, exe, pdf", "Germany", 90000);

}


