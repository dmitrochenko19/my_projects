package ru.app.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Database for StudentsDao
 * if you use StudentsDao2 set up connection to real database
 */
public class Student {
    private int id;
    @NotEmpty(message = "name shouldn't be empty")
    @Size(min = 2, max = 30, message = "name should be longer than 2 characters and shorter than 30 characters")
    private String name;
    private int age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "incorrect date")
    @NotNull(message = "date should not be empty")
    private Date birthdate;
    private String sex;

    public Student() {

    }

    public Student(String name, Date birthDate, String sex) {
        this.name = name;
        this.birthdate = birthDate;
        this.sex = sex;
        this.age = countAge(birthDate);
    }

    public static int countAge(Date birthDate) {
        Date currentDate = new Date(new java.util.Date().getTime());
        long diffInMillies = Math.abs(currentDate.getTime() - birthDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) / 365;
        return (int) diff;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
        setAge(countAge(birthdate));
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getSQLDate() {
        java.sql.Date date = new java.sql.Date(birthdate.getYear(), birthdate.getMonth(), birthdate.getDate());
        return date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthdate +
                ", sex='" + sex + '\'' +
                '}';
    }
}
