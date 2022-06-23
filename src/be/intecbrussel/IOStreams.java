package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class IOStreams {
    public static void main(String[] args) {
//        writeToFile();
        readFromFile();
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

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            Scanner scanner = new Scanner(System.in);
            String sentence = scanner.nextLine();

            bufferedWriter.write("\n" + sentence);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromFile() {
        Path path = Paths.get("MyFolder/Secrets/Secret.txt");

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {

            String sentence = bufferedReader.readLine();
            System.out.println(sentence);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
