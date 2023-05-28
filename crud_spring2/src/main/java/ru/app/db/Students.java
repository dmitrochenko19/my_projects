package ru.app.db;

import ru.app.models.Student;

import java.util.Date;
import java.util.ArrayList;

public class Students {
    private static int count = 0;
    private static ArrayList<Student> students;

    static {
        students = new ArrayList<>();
        addStudent(new Student("Tom", new Date(1999 - 1900, 1 - 1, 1), "man"));
        addStudent(new Student("Den", new Date(1976 - 1900, 11 - 1, 15), "man"));
        addStudent(new Student("Katy", new Date(2004 - 1900, 3 - 1, 21), "woman"));
    }

    public static void addStudent(Student student) {
        count++;
        student.setId(count);
        students.add(student);
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }
}