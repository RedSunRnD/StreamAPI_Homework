package service;

import domain.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Employee getEmployeeWithMaxSalaryByDepartment(String departmentID) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(e -> e.getDepartment().equals(departmentID))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeWithMinSalaryByDepartment(String departmentID) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(e -> e.getDepartment().equals(departmentID))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Map<String, List<Employee>> getAllEmployeesByDepartment(String departmentID) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(e -> e.getDepartment().equals(departmentID))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<String, List<Employee>> getAllEmployeesByDepartments() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
