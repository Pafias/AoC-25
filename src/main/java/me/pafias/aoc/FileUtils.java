package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

    public static String readFileAsString(String file) {
        try {
            return new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\" + file)));
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> readFileAsLines(String file) {
        try {
            return Files.readAllLines(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\" + file));
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
