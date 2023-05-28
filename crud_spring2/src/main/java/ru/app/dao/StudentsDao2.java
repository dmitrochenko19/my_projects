package ru.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import ru.app.db.Students;
import ru.app.models.Student;

import java.sql.*;
import java.util.List;

@Component
public class StudentsDao2 {
    private static Connection connection;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentsDao2(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> index() {
        return jdbcTemplate.query("select * from students", new BeanPropertyRowMapper<>(Student.class));
    }

    public Student show(int id) {
        return jdbcTemplate.query("select * from students where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Student.class))
                .stream().findAny().orElse(null);
    }

    public void create(Student student) {
        jdbcTemplate.update("insert into students(name, birthdate, age, sex) values(?,?,?,?)", student.getName(), student.getBirthdate(), student.getAge(), student.getSex());
    }

    public void update(int id, Student newStudent) {
        jdbcTemplate.update("update students set name = ?, birthdate =?, age =?, sex = ? where id = ?",
                newStudent.getName(), newStudent.getSQLDate(), newStudent.getAge(), newStudent.getSex(), id);
    }

    public void delete(int id) throws SQLException {
        jdbcTemplate.update("delete from students where id = ?", id);
    }

    public Double getMediumAge() {
        return jdbcTemplate.queryForObject("select round(avg(age),2) from students", Double.class);

    }

}
