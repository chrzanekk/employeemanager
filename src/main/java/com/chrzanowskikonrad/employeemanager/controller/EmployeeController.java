package com.chrzanowskikonrad.employeemanager.controller;

import com.chrzanowskikonrad.employeemanager.model.EmployeeDTO;
import com.chrzanowskikonrad.employeemanager.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController {

    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        log.debug("REST request to get all employees.");
        List<EmployeeDTO> employeeList = employeeService.findAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id) {
        log.debug("REST request to find employee by id: {}", id);
        EmployeeDTO employeeDTO = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        log.debug("REST request to add new employee: {}", employeeDTO);
        EmployeeDTO newEmployeeDTO = employeeService.addEmployee(employeeDTO);
        return new ResponseEntity<>(newEmployeeDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        log.debug("REST request to update existing employee: {}", employeeDTO);
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(employeeDTO);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        log.debug("REST request to delete employee by id: {}", id);
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
