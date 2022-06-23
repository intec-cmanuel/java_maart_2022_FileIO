package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOStreams {
    public static void main(String[] args) {
        writeToFile();
//        readFromFile();
    }

    private static void writeToFile() {
        Path path = Paths.get("MyFolder/Secrets/Secret.txt");


//        try (Writer writer = new FileWriter(path.toFile());
//             BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
//
//            bufferedWriter.write("Ik ben Jean-Nuit");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {

            bufferedWriter.write("Ik ben Jean-Luc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromFile() {

    }
}
