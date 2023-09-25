package package1;

import java.io.File;
import java.io.IOException;

public class Homework9 {

    private static final String INFO = "INFO";
    private static final String DEBUG = "DEBUG";
    private static final String WARNING = "WARNING";
    private static final String ALL = "ALL";
    private static final String path = "log.txt";

    private static String inf1 = "Starting JuniorCrudServiceApplication using Java 17.0.7";
    private static String deb1 = "User admin created";

    private static void testCreateFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("---------------Task №1---------------");
        testCreateFile(path);

        System.out.println("---------------Task №2---------------");
        Logger log = new Logger(path);

        log.addLog(INFO, inf1);
        log.addLog(DEBUG, deb1);
        log.addLog(WARNING, "Coffee is too hot!");
        System.out.println("Added 3 records.");

        System.out.println("---------------Task №3---------------");
        System.out.println("All logs " + "\n" + log.getLog(ALL));

        System.out.println("---------------Task №4 & №5---------------");
        System.out.println("Logs with parameter " + INFO + "\n" + log.getLog(INFO));
        System.out.println("Logs with parameter " + DEBUG + "\n" + log.getLog(DEBUG));
        System.out.println("Logs with parameter " + WARNING + "\n" + log.getLog(WARNING));

    }
}
