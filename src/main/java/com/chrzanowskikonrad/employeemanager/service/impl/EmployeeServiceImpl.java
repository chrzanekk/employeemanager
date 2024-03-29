package com.chrzanowskikonrad.employeemanager.service.impl;

import com.chrzanowskikonrad.employeemanager.domain.Employee;
import com.chrzanowskikonrad.employeemanager.exception.UserNotFoundException;
import com.chrzanowskikonrad.employeemanager.model.EmployeeDTO;
import com.chrzanowskikonrad.employeemanager.repository.EmployeeRepository;
import com.chrzanowskikonrad.employeemanager.service.EmployeeService;
import com.chrzanowskikonrad.employeemanager.service.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        log.debug("Adding new employee: {}", employeeDTO);
        Employee employeeToSave = employeeMapper.toEntity(employeeDTO);
        employeeToSave.setEmployeeCode(UUID.randomUUID().toString());
        Employee employee = employeeRepository.save(employeeToSave);
        EmployeeDTO newEmployee = employeeMapper.toDto(employee);
        return newEmployee;
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        log.debug("Finding all employees.");
        List<EmployeeDTO> foundList = employeeRepository.findAll().stream().map(employeeMapper::toDto).collect(Collectors.toList());
        log.debug("Found: {}",foundList);
        return foundList;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        log.debug("Updating existing employee: {}", employeeDTO);
        Employee employee = employeeRepository.save(employeeMapper.toEntity(employeeDTO));
        return employeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDTO findEmployeeById(Long id) {
        log.debug("Finding employee by id: {}", id);
        return employeeMapper.toDto(employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException(
                "User by id " + id + "was not found")));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
