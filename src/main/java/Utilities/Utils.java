package Utilities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Utils {

    public static String getRandomData(String type) {
        List<String> lines;
        try {
            File file = new File("src/main/resources/Data/" + type + ".txt");
            lines = FileUtils.readLines(file, "UTF-8");
            int lineInTxtFile = getRandomInt(lines.size());
            return lines.get(lineInTxtFile);
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    private static int getRandomInt(int max) {
        return (int)(Math.random() * (max + 1));
    }
}
