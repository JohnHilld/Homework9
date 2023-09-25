package package1;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;

public class Logger {

    private final String ALL = "ALL";
    private String filePath;

    public Logger(String path) {
        filePath = path;
    }

    public void addLog(String type, String info) {
        Writer writer = null;
        try {
            writer = new FileWriter(filePath, true);
            writer.write(type + ": " + info + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLog(String type) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                if(compareType(type, line) || (type == ALL)){
                    builder.append(line).append("\n");
                } else {
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (builder.toString());
    }

    private boolean compareType(String type, String line) {
        for (int i = 0; i < type.length(); i++) {
            if(type.charAt(i) == line.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
