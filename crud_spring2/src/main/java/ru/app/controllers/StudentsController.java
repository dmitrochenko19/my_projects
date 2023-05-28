package ru.app.controllers;

import jakarta.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.app.dao.StudentsDao;
import ru.app.dao.StudentsDao2;
import ru.app.models.Student;

import java.sql.SQLException;
import java.util.Date;

@Controller
@RequestMapping("/students")
public class StudentsController {
    private StudentsDao2 studentsDao;

    @Autowired
    public StudentsController(StudentsDao2 studentsDao) {
        this.studentsDao = studentsDao;
    }

    @GetMapping()
    public String index(Model model) throws SQLException {
        model.addAttribute("students", studentsDao.index());
        model.addAttribute("mediumAge", studentsDao.getMediumAge());
        return "students/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("student", studentsDao.show(id));
        return "students/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("student", new Student());
        return "students/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors())
            return "students/new";
        studentsDao.create(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("student", studentsDao.show(id));
        return "students/edit";

    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("student") @Valid Student student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors())
            return "students/edit";
        studentsDao.update(id, student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws SQLException {
        studentsDao.delete(id);
        return "redirect:/students";
    }


}
