package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.dao.EmployeeDao;
import com.example.model.Employee;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao dao;

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("list", dao.findAll());
        return "list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee emp) {
        dao.save(emp);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        dao.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("employee", dao.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee emp) {
        dao.update(emp);
        return "redirect:/";
    }
}