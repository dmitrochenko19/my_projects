package ru.app.dao;

import org.springframework.stereotype.Component;
import ru.app.db.Students;
import ru.app.models.Student;

import java.util.List;

/**
 * You can use StudentsDao instead of StudentDao2
 * if you don't want to create connection to database
 */
@Component
public class StudentsDao {
    public List<Student> index() {
        return Students.getStudents();
    }

    public Student show(int id) {
        return Students.getStudents().stream().filter(student -> student.getId() == id).findAny().orElse(null);
    }

    public void create(Student student) {
        Students.addStudent(student);
    }

    public void update(int id, Student newStudent) {
        System.out.println(id
        );
        System.out.println(show(id));
        Student studentToBeUpdated = show(id);
        studentToBeUpdated.setName(newStudent.getName());
        studentToBeUpdated.setBirthdate(newStudent.getBirthdate());
        studentToBeUpdated.setSex(newStudent.getSex());
        studentToBeUpdated.setAge(Student.countAge(studentToBeUpdated.getBirthdate()));
    }

    public void delete(int id) {
        Students.getStudents().removeIf(st -> st.getId() == id);
    }

    public int getMediumAge() {
        if (Students.getStudents().isEmpty())
            return 0;
        return Students.getStudents().stream().mapToInt(Student::getAge).sum() / Students.getStudents().size();
    }
}
