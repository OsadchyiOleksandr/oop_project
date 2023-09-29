package qa_automation;

/**
 * Creator Osadchyi Oleksandr 4:00 AM  17 September 2023
 * Commands for Build and Run Project
 * clear && mvn clean && mvn install
 * mvn exec:java -Dexec.mainclass=classes.qa_automation.App
 */

import qa_automation.appbody.Main;
import qa_automation.appbody.projectexceptions.MaxSalaryException;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, MaxSalaryException {
        //Entery point
        Main.startProcess();
    }
}
