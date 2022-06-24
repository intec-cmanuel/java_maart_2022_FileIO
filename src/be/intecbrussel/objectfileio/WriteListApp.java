package be.intecbrussel.objectfileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteListApp {
    public static void main(String[] args) {
        Path path = Paths.get("MyFolder/people.ser");
        Person person = RegisterApp.createPerson();

        List<Person> people = getList();
        people.add(person);

        try (FileOutputStream fos = new FileOutputStream(path.toFile());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(people);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<Person> getList() {
        return ReadListApp.getPeopleList();
    }
}
