package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    EmployeeService employeeService = new EmployeeService();


    @Test
    void addEmployee() {

    }

    @BeforeEach
    public void setUp() {
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
    }
    @Test

    void getSalarySum() {

        int expected = employeeService.getSalarySum();
        int actual = 1000 + 1000;

        assertEquals(expected, actual);
    }

    @Test
    void getMinSalary() {
        OptionalInt expected = employeeService.getMinSalary();
        OptionalInt actual = OptionalInt.of(1000);

        assertEquals(expected, actual);
    }

    @Test
    void getMaxSalary() {
        OptionalInt expected = employeeService.getMaxSalary();
        OptionalInt actual = OptionalInt.of(1000);

        assertEquals(expected, actual);
    }
}