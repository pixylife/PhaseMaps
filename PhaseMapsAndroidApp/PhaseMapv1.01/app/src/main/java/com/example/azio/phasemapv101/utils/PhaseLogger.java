package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhaseLogger {
    static File log;

    public PhaseLogger() {
        // create or open file if exists
        log = new File("log.txt");
    }

    public void print(String entry) {
        try {
            // writers in append and auto flush mode
            FileWriter fw = new FileWriter(log, true);
            PrintWriter pw = new PrintWriter(fw, true);

            // current timestamp
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

            // log given entry with timestamp
            pw.println(timeStamp + " " + entry);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
