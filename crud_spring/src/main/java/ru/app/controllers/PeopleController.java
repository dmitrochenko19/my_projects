package ru.app.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.app.dao.PeopleDao;
import ru.app.dao.PeopleDao2;
import ru.app.models.Person;

import java.sql.SQLException;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PeopleDao2 peopleDao;

    @Autowired
    public PeopleController(PeopleDao2 peopleDao) {
        this.peopleDao = peopleDao;
    }

    @GetMapping()
    public String index(Model model) throws SQLException {
        model.addAttribute("people", peopleDao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("person",peopleDao.show(id));
        return "people/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) throws SQLException {
        if(bindingResult.hasErrors())
            return "/people/new";
        peopleDao.create(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("person", peopleDao.show(id));
        return "people/edit";

    }
    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("person") @Valid Person person, BindingResult bindingResult) throws SQLException {
        if(bindingResult.hasErrors())
            return "/people/edit";
        peopleDao.update(id,person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws SQLException {
        peopleDao.delete(id);
        return "redirect:/people";
    }
}
