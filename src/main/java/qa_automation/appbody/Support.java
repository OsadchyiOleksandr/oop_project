package qa_automation.appbody;

/**
 * Class with static methods for make some actions or default values for variables
 */

import qa_automation.appbody.projectexceptions.MaxSalaryException;

import java.io.*;

public class Support {
    public static BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

    public final static String DEFAULT = "no data";

    public static int strToInt(String str){
        int num = 0;
        try{
            num = Integer.parseInt(str);
        } catch (NumberFormatException e){
            System.out.println("ERROR: Not Integer");
        }
        return num;
    }

    public static void writeToFile(String text, String fileName) throws MaxSalaryException, IOException {
        try{
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            Main.startProcess();
        }
    }
}