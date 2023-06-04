package dev.tharusha.wijayabahu.springcrud.service;

import dev.tharusha.wijayabahu.springcrud.dto.EmployeeDTO;
import dev.tharusha.wijayabahu.springcrud.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO getEmployeeById(long employeeId);

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
}
