package com.example.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.model.Employee;

@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Employee emp) {
        jdbcTemplate.update(
            "INSERT INTO employee(name,email,department) VALUES(?,?,?)",
            emp.getName(), emp.getEmail(), emp.getDepartment());
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM employee",
            (rs, rowNum) -> {
                Employee e = new Employee();
                e.setId(rs.getLong("id"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setDepartment(rs.getString("department"));
                return e;
            });
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM employee WHERE id=?", id);
    }

    public Employee findById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM employee WHERE id=?",
            new Object[]{id},
            (rs, rowNum) -> {
                Employee e = new Employee();
                e.setId(rs.getLong("id"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setDepartment(rs.getString("department"));
                return e;
            });
    }

    public void update(Employee emp) {
        jdbcTemplate.update(
            "UPDATE employee SET name=?, email=?, department=? WHERE id=?",
            emp.getName(), emp.getEmail(), emp.getDepartment(), emp.getId());
    }
}