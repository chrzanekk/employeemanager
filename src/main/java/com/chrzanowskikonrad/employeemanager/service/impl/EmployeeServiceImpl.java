package com.chrzanowskikonrad.employeemanager.service.impl;

import com.chrzanowskikonrad.employeemanager.domain.Employee;
import com.chrzanowskikonrad.employeemanager.exception.UserNotFoundException;
import com.chrzanowskikonrad.employeemanager.model.EmployeeDTO;
import com.chrzanowskikonrad.employeemanager.repository.EmployeeRepository;
import com.chrzanowskikonrad.employeemanager.service.EmployeeService;
import com.chrzanowskikonrad.employeemanager.service.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employeeToSave = employeeMapper.toEntity(employeeDTO);
        employeeToSave.setEmployeeCode(UUID.randomUUID().toString());
        Employee employee = employeeRepository.save(employeeToSave);
        EmployeeDTO newEmployee = employeeMapper.toDto(employee);
        return newEmployee;
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.save(employeeMapper.toEntity(employeeDTO));
        return employeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDTO findEmployeeById(Long id) {
        return employeeMapper.toDto(employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException(
                "User by id " + id + "was not found")));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
