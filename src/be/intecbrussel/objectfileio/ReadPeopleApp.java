package be.intecbrussel.objectfileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadPeopleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who do you want to see?");
        String name = scanner.nextLine();

        readPerson(name);
    }

    public static void readPerson(String name){
        Path path = Paths.get("MyFolder/people/" + name + ".ser");

        try (FileInputStream fis = new FileInputStream(path.toFile());
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Object object = ois.readObject();
            Person person = (Person) object;
            System.out.println(person);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
