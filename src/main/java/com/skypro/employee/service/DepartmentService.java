package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private  EmployeeRepository employeeRepository;

    public DepartmentService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private final Map<Integer, Employee> employeesDepartment = new HashMap<>();

    public Employee addEmployee(int id, Employee employee) {
        this.employeesDepartment.put(id, employee);
        return employee;
    }

    public Collection<Employee> getAllEmployees() {
        return this.employeeRepository.getEmployees();
    }

    public Collection<Employee> getAllDepartmentEmployees(int id) {
        return employeeRepository.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == id)
                .collect(Collectors.toList());
    }

    public int getSalarySum(int id) {
        return getAllDepartmentEmployees(id).stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public OptionalInt getMaxSalary(int id) {
        return getAllDepartmentEmployees(id).stream()
                .mapToInt(Employee::getSalary)
                .max();
    }
}
