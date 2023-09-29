package qa_automation.appbody.db;

import qa_automation.appbody.Support;
import qa_automation.appbody.projectexceptions.MaxSalaryException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.util.Scanner;

public final class DataBase {

    public String dbStatus = "";

    public DataBase() throws MaxSalaryException, IOException {
        this.dbStatus = initializeDB();
    }

    private static String initializeDB() throws MaxSalaryException, IOException {
        String status = "DB exist";
        File file = new File("db.txt");
        try{
            Scanner scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            status = "No DB";
            System.out.println(status + "\t" + e);
        } finally {
            Support.writeToFile(String.format("Log\t%s\n", status), "logs.txt");
            Support.writeToFile(String.valueOf(Instant.now()), "logs.txt");
            Support.writeToFile("\nDB event\n\n", "logs.txt");
        }
        return status;
    }
}
