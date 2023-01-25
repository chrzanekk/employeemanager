package com.chrzanowskikonrad.employeemanager.service;

import com.chrzanowskikonrad.employeemanager.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {


    Employee addEmployee(Employee employee);

    List<Employee> findAllEmployees();

    Employee updateEmployee(Employee employee);

    Employee findEmployeeById(Long id);

    void deleteEmployee(Long id);
}
