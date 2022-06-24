package be.intecbrussel.objectfileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadEveryoneApp {
    public static void main(String[] args) {
        try {

            Files.walk(Paths.get("MyFolder/people"))
                    .filter(path -> path.toString().endsWith(".ser"))
                    .map(path -> path.getFileName().toString())
                    .map(filename -> filename.substring(0, filename.lastIndexOf(".")))
                    .forEach(name -> ReadPeopleApp.readPerson(name));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
