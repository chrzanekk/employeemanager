package com.chrzanowskikonrad.employeemanager.service.impl;

import com.chrzanowskikonrad.employeemanager.exception.UserNotFoundException;
import com.chrzanowskikonrad.employeemanager.model.Employee;
import com.chrzanowskikonrad.employeemanager.repository.EmployeeRepository;
import com.chrzanowskikonrad.employeemanager.service.EmployeeService;

import java.util.List;
import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + "was not found"));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
