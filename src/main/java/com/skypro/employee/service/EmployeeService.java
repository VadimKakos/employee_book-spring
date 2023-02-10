package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    //private final Map<Integer, Employee> employees = new HashMap<>();

    EmployeeRepository employeeRepository = new EmployeeRepository();
  //  public Collection<Employee> getAllEmployees() {
    //    return this.employees.values();
    //}

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Employee name should be set");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());
       // this.employees.put(employee.getId(), employee);

        employeeRepository.addEmployee(employee);
        return employee;
    }

    public int getSalarySum() {
        return employeeRepository.getEmployees().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }
}
