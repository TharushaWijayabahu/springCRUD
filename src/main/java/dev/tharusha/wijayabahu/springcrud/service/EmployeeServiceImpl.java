package dev.tharusha.wijayabahu.springcrud.service;

import dev.tharusha.wijayabahu.springcrud.dto.EmployeeDTO;
import dev.tharusha.wijayabahu.springcrud.entity.EmployeeEntity;
import dev.tharusha.wijayabahu.springcrud.exception.CRUDException;
import dev.tharusha.wijayabahu.springcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<EmployeeEntity> result = employeeRepository.findAll();
        if (result.isEmpty()) {
            throw new CRUDException(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Employees not found"));
        }
        return result.stream().map(
                employee -> EmployeeDTO.build(employee.getEmployeeId(), employee.getName(), employee.getAge(), employee.getSalary())
        ).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(long employeeId) {
        EmployeeEntity result = employeeRepository.findByEmployeeId(employeeId);
        if (result == null) {
            throw new CRUDException("Employee not found", new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
        } else {
            return EmployeeDTO.build(result.getEmployeeId(), result.getName(), result.getAge(), result.getSalary());
        }
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity result = employeeRepository.findByEmployeeId(employeeDTO.getId());
        if (result != null) {
            throw new CRUDException("Employee already registered", new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
        } else {
            EmployeeEntity employee = employeeRepository.save(EmployeeEntity.build(employeeDTO.getId(), employeeDTO.getName(),
                    employeeDTO.getAge(), employeeDTO.getSalary()));
            return EmployeeDTO.build(employee.getEmployeeId(), employee.getName(), employee.getAge(), employee.getSalary());
        }
    }
}
