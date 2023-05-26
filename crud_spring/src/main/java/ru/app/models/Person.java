package ru.app.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import javax.management.remote.JMXServerErrorException;

public class Person {
    private int id;
    @NotEmpty(message = "name shouldn't be empty")
    @Size(min=2,max = 30, message = "name should be longer than 2 characters and shorter than 30 characters")
    private String name;
    @Min(value = 0, message = "incorrect age")
    private int age;
    @Email(message = "incorrect email")
    private String email;
    public Person(){

    }

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
