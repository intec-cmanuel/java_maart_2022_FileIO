package be.intecbrussel.objectfileio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class RegisterApp {
    public static void main(String[] args) {
        Person person = createPerson();
        makeDirectoriesAndFile(person);
        registerPerson(person);
    }

    public static Person createPerson(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("How old are you?");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Where are you born");
        String birthplace = scanner.nextLine();

        System.out.println("How much do you earn");
        double salary = scanner.nextDouble();

        Person person = new Person(name, age, birthplace, salary);
        return person;
    }

    private static void registerPerson(Person person) {
        // Als de person jean genaamd is -> MyFolder/people/jean.ser
        Path path = Paths.get("MyFolder/people/" + person.getName() + ".ser");

        try (FileOutputStream fos = new FileOutputStream(path.toFile());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(person);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void makeDirectoriesAndFile(Person person) {
        Path path = Paths.get("MyFolder/people/" + person.getName() + ".ser");
        File file = path.toFile();

        // Als MyFolder/people niet bestaat, maken we die aan
        if (!Files.exists(path.getParent())) {
            try {
                Files.createDirectories(path.getParent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Maak de jean.ser file aan
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
