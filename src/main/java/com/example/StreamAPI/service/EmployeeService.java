package com.example.StreamAPI.service;

import com.example.StreamAPI.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final Map<String, Employee> employees;
    public EmployeeService() {
        employees = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        String fullName = employee.getFirstName() + " " + employee.getLastName();
        employees.put(fullName, employee);
    }

    public Employee removeEmployee(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        employees.remove(fullName);
        return null;
    }

    public Employee findEmployee(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        return employees.get(fullName);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    public void addTestData() {
        employees.put("Иванов", new Employee("Иван", "Иванов", 20000, "1"));
        employees.put("Петров", new Employee("Петр", "Петров", 15000, "2"));
        employees.put("Сидоров", new Employee("Сидор", "Сидоров", 30000, "3"));
    }
}
