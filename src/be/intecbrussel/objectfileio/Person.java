package be.intecbrussel.objectfileio;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String name;
    private int age;
    private String birthplace;
    private double salary;

    public Person(String name, int age, String birthplace, double salary) {
        this.name = name;
        this.age = age;
        this.birthplace = birthplace;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Double.compare(person.salary, salary) == 0 && Objects.equals(name, person.name) && Objects.equals(birthplace, person.birthplace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthplace, salary);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthplace='" + birthplace + '\'' +
                ", salary=" + salary +
                '}';
    }
}
