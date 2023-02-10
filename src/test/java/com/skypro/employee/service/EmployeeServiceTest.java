package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    EmployeeService employeeService = new EmployeeService();






    @Test
    void addEmployee() {

    }

    @Test
    void getSalarySum() {
        EmployeeRequest employee = new EmployeeRequest();
        EmployeeRequest employee1 = new EmployeeRequest();

        employee1.setFirstName("name");
        employee1.setLastName("name");
        employee1.setDepartment(1);
        employee1.setSalary(1000);

        employee.setFirstName("name");
        employee.setLastName("name");
        employee.setDepartment(1);
        employee.setSalary(1000);
        employeeService.addEmployee(employee);
        employeeService.addEmployee(employee1);
        int expected = employeeService.getSalarySum();
        int actual = 1000 + 1000;

        assertEquals(expected, actual);
    }

    @Test
    void getMinSalary() {
    }

    @Test
    void getMaxSalary() {
    }
}