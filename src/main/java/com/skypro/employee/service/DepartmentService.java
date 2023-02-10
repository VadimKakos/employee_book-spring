package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private EmployeeRepository employeeRepository;

    public DepartmentService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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

    public OptionalInt getMinSalary(int id) {
        return getAllDepartmentEmployees(id).stream()
                .mapToInt(Employee::getSalary)
                .min();
    }

    public Set<Integer> getExistingDepartment() {
        return employeeRepository.getEmployees().stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
    }

    public Map<Integer, Collection<Employee>> getEmployeesByDepartment() {
        return getExistingDepartment().stream()
                .collect(Collectors.toMap(dept -> dept, this::getAllDepartmentEmployees));
    }
}
