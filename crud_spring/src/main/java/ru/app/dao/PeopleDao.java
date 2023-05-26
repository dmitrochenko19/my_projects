package ru.app.dao;

import org.springframework.stereotype.Component;
import ru.app.db.People;
import ru.app.models.Person;

import java.util.List;

@Component
public class PeopleDao {
    public List<Person> index(){
        return People.getPeople();
    }
    public Person show(int id){
        return People.getPeople().stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
    public void create(Person person){
        People.addPerson(person);
    }
    public void update(int id, Person newPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(newPerson.getName());
        personToBeUpdated.setAge(newPerson.getAge());
    }
    public void delete(int id){
        People.getPeople().removeIf(p->p.getId()==id);
    }
}
