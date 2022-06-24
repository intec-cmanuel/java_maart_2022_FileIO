package be.intecbrussel.objectfileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadListApp {
    public static void main(String[] args) {
        List<Person> people = getPeopleList();
        people.forEach(person -> System.out.println(person));
    }

    public static List<Person> getPeopleList() {
        Path path = Paths.get("MyFolder/people.ser");

        try (FileInputStream fis = new FileInputStream(path.toFile());
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Object object = ois.readObject();
            List<Person> people = (List<Person>) object;
            return people;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
