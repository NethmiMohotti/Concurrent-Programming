package lk.iit.level6.concurrent.coursework;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityFile {
        private static final String OUTPUT_FILE_PATH = "resultOutput.txt";

        private static FileWriter fileWriter;
        private static PrintWriter printWriter;

        static {
            try {
                fileWriter = new FileWriter(OUTPUT_FILE_PATH);
                printWriter = new PrintWriter(fileWriter,true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static synchronized void writeToFile(String message) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
            printWriter.println("[" + timestamp + "] " + message);
        }

        public static void closeFile() {
            printWriter.close();
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
 }
}

    }
