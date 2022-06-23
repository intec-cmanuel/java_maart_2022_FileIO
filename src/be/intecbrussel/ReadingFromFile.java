package be.intecbrussel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadingFromFile {
    public static void main(String[] args) {
        Path path = Paths.get("MyFolder/Secrets/Secret.txt");

        try {

            List<String> people = Files.readAllLines(path);
            people.forEach(person -> System.out.println(person));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
