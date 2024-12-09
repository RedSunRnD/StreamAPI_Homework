package com.example.StreamAPI.controller;

import com.example.StreamAPI.domain.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.StreamAPI.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee getEmployeeWithMaxSalaryByDepartment(@RequestParam String departmentID) {
        return departmentService.getEmployeeWithMaxSalaryByDepartment(departmentID);
    }

    @GetMapping(path = "/min-salary")
    public Employee getEmployeeWithMinSalaryByDepartment(@RequestParam String departmentID) {
        return departmentService.getEmployeeWithMinSalaryByDepartment(departmentID);
    }

    @GetMapping(path = "/all")
    public Map<String, List<Employee>> getAllEmployeesByDepartment(@RequestParam(required = false) String departmentID) {
        if (departmentID == null) {
            return departmentService.getAllEmployeesByDepartments();
        }
        return departmentService.getAllEmployeesByDepartment(departmentID);
    }
}

