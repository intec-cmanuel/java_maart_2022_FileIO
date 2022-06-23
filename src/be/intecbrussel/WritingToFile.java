package be.intecbrussel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WritingToFile {
    public static void main(String[] args) {
//        Path path2 = Paths.get("");
//        System.out.println(path2.toAbsolutePath());

        Path path = Paths.get("MyFolder/Secrets");
        String data = "The toufikmobile needs new breaks URGENTLY.";

        try {
            Files.writeString(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> people = new ArrayList<>();
        people.add("Jean-Bon");
        people.add("Jean-Vie");
        people.add("Jean-tille");
        people.add("Jean-nuit");

        try {
            Files.write(path, people);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
