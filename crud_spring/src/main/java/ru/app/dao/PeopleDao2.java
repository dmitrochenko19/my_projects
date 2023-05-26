package ru.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.app.models.Person;

import java.sql.*;
import java.util.List;

@Component
public class PeopleDao2 {
    private static Connection connection;
   private JdbcTemplate jdbcTemplate;
   @Autowired
   public PeopleDao2(JdbcTemplate jdbcTemplate){
       this.jdbcTemplate = jdbcTemplate;
   }
    public List<Person> index() {
       return jdbcTemplate.query("select * from people", new BeanPropertyRowMapper<>(Person.class));
    }
    public Person show(int id) {
       return jdbcTemplate.query("select * from people where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
               .stream().findAny().orElse(null);
    }
    public void create(Person person) {
       jdbcTemplate.update("insert into people(name, age, email) values(?,?,?)", person.getName(), person.getAge(), person.getEmail());
    }
    public void update(int id, Person newPerson) {
      jdbcTemplate.update("update people set name = ?, age =?, email =? where id = ?",
              newPerson.getName(),newPerson.getAge(),newPerson.getEmail(),id);
    }
    public void delete(int id) throws SQLException {
      jdbcTemplate.update("delete from people where id = ?", id);
    }

}
