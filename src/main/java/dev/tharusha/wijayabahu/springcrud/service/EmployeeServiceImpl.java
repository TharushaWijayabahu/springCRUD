package dev.tharusha.wijayabahu.springcrud.service;

import dev.tharusha.wijayabahu.springcrud.entity.EmployeeEntity;
import dev.tharusha.wijayabahu.springcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        Optional<EmployeeEntity> result = getEmployeeById(employeeEntity.getEmployeeId());
        return result.orElseGet(() -> employeeRepository.save(employeeEntity));
    }
}
