package be.intecbrussel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HowDoFilesWork {
    public static void main(String[] args) {
        // Absolute Path
        String pathToSecret = "C:\\Users\\Trace\\OneDrive - INTEC BRUSSEL vzw\\Intec\\Opleidingen\\Java Maart 2022\\Lessen\\FileIO";
        // Relative Path
        String relativePath = "MyFolder/Secrets";

        File file = new File(pathToSecret);

        Path path = Paths.get(pathToSecret);

//        try {
//            boolean didItWork = file.createNewFile();
//            System.out.println(didItWork);
//            file.delete();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println(path);
        path = path.resolve("MyFolder");
        System.out.println(path);
        path = path.resolve("Secrets/Secret.txt");
//        path = path.resolve("Secrets\\Secret.txt");
        System.out.println(path);


        Path pathWithRelative = Paths.get(relativePath);
        pathWithRelative = pathWithRelative.resolve("Secret.txt");
        System.out.println(pathWithRelative);

        Path fileToPath = file.toPath();
        File pathToFile = path.toFile();
    }
}
