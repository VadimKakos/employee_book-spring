package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository = new EmployeeRepository();


    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Employee name should be set");
        }

        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());

        employeeRepository.addEmployee(employee);
        return employee;
    }

    public int getSalarySum() {
        return employeeRepository.getEmployees().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public OptionalInt getMinSalary() {
        return employeeRepository.getEmployees().stream()
                .mapToInt(Employee::getSalary)
                .min();
    }

    public OptionalInt getMaxSalary() {
        return employeeRepository.getEmployees().stream()
                .mapToInt(Employee::getSalary)
                .max();
    }
}
