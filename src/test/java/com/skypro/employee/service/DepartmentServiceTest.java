package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private DepartmentService departmentService;

    private List<Employee> actualEmployees;


    @BeforeEach
    public void setUp() {
        Employee employee1 = new Employee("firstName", "lastName", 1, 1000);
        Employee employee2 = new Employee("firstName", "lastName", 1, 1000);
        Employee employee3 = new Employee("firstName", "lastName", 1, 1000);

        actualEmployees = new ArrayList<>(List.of(employee1, employee2, employee3));

        when(employeeRepository.getEmployees()).thenReturn((ArrayList<Employee>) actualEmployees);
    }
    @Test
    void getAllEmployees() {
        int id = 1;
        List<Employee> actual = actualEmployees.stream()
                .filter(e -> e.getDepartment() == id)
                .collect(Collectors.toList());
        List<Employee> expected = employeeRepository.getEmployees();
        assertEquals(actual, expected);
    }

    @Test
    void getAllDepartmentEmployees() {
        int depId = 1;
        List<Employee> actual = actualEmployees.stream()
                .filter(e -> e.getDepartment() == depId)
                .collect(Collectors.toList());
        List<Employee> expected = employeeRepository.getEmployees();
        assertEquals(actual, expected);

    }

    @Test
    void getSalarySum() {
        int id = 1;
        int actual = actualEmployees.stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(Employee::getSalary)
                .sum();
        int expected = departmentService.getSalarySum(id);
        assertEquals(expected,actual);
    }

    @Test
    void getMaxSalary() {
        int id = 1;
        OptionalInt actual = actualEmployees.stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(Employee::getSalary)
                .max();
        OptionalInt expected = departmentService.getMaxSalary(id);
        assertEquals(expected,actual);
    }

    @Test
    void getMinSalary() {
        int id = 1;
        OptionalInt actual = actualEmployees.stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(Employee::getSalary)
                .min();
        OptionalInt expected = departmentService.getMinSalary(id);
        assertEquals(expected,actual);
    }

    @Test
    void getExistingDepartment() {
       final Set<Integer> actual = actualEmployees.stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
       final Set<Integer> expected = departmentService.getExistingDepartment();
        assertEquals(actual, expected);

    }

    @Test
    void getEmployeesByDepartment() {
        Map<Integer, List<Employee>> actual = actualEmployees.stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet()).stream()
                .collect(Collectors.toMap(dept -> dept, dept -> actualEmployees.stream().filter(e -> e.getDepartment() == dept).collect(Collectors.toList())));
        Map<Integer, Collection<Employee>> expected = departmentService.getEmployeesByDepartment();
        assertEquals(actual,expected);
    }
}