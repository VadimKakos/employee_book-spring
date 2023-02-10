package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EmployeeRepository {

    private static int lastId;
    private static final ArrayList<Employee> employees = new ArrayList<>();



    public static Integer getLastId() {
        return lastId;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employees) {
        this.employees.add(employees);
        lastId++;
    }
}
