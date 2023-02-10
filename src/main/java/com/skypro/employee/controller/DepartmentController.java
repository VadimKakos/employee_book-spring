package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.OptionalInt;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("department/{id}/employees")
    public Collection<Employee> getAllDepartmentEmployees(@PathVariable("id") int id ) {
        return this.departmentService.getAllDepartmentEmployees(id);
    }

    @GetMapping("/allEmployees")
    public Collection<Employee> getAllEmployees() {
    return this.departmentService.getAllEmployees();
      }
    @GetMapping("/department/{id}/salary/sum")
    public int getSumDepartment(@PathVariable("id") int id) {
        return this.departmentService.getSalarySum(id);
    }

    //GET http://localhost:8080/department/{id}/salary/max
      //      — возвращает максимальную зарплату по департаменту.

    @GetMapping("department/{id}/salary/max")
    public OptionalInt getMaxSalaryDepartment(@PathVariable("id") int id) {
        return this.departmentService.getMaxSalary(id);
    }
/*
    @PostMapping("/salary/min")
    public Employee getMinSalaryDepartment(@RequestBody EmployeeRequest employeeRequest) {
        return this.departmentService.addEmployee(employeeRequest);
    }

    @GetMapping("/employees")
    public int getAllEmployeesOfDepartment() {
        return this.departmentService.getSalarySum();
    }
*/
}
