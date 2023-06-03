package dev.tharusha.wijayabahu.springcrud.service;

import dev.tharusha.wijayabahu.springcrud.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeEntity> getAllEmployee();

    Optional<EmployeeEntity> getEmployeeById(long employeeId);

    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
}
