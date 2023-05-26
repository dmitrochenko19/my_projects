package ru.app.db;

import ru.app.models.Person;

import java.util.ArrayList;

public class People {
    private static int count = 0;
    private static ArrayList<Person> people;
    static {
        people = new ArrayList<>();
        addPerson(new Person("Tom", 25,"ttr@gmail.com"));
        addPerson(new Person("Den",33,"tdt@mail.tu"));
        addPerson(new Person("Fedor",42,"fff@yandex.ru"));
    }
    public static void addPerson(Person person){
        count++;
        person.setId(count);
        people.add(person);
    }

    public static ArrayList<Person> getPeople() {
        return people;
    }
}
