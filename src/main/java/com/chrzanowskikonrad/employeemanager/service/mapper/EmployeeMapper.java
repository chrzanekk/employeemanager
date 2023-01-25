package com.chrzanowskikonrad.employeemanager.service.mapper;

import com.chrzanowskikonrad.employeemanager.domain.EmployeeDTO;
import com.chrzanowskikonrad.employeemanager.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {

    default Employee fromId(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }
}
