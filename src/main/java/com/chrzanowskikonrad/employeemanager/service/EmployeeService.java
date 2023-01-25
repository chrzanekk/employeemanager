package com.chrzanowskikonrad.employeemanager.service;

import com.chrzanowskikonrad.employeemanager.domain.EmployeeDTO;
import com.chrzanowskikonrad.employeemanager.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> findAllEmployees();

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO findEmployeeById(Long id);

    void deleteEmployee(Long id);
}
