package dev.tharusha.wijayabahu.springcrud.controller;

import dev.tharusha.wijayabahu.springcrud.entity.EmployeeEntity;
import dev.tharusha.wijayabahu.springcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "{employeeId}", produces = "application/json")
    public ResponseEntity<Optional<EmployeeEntity>> getEmployeeById(@PathVariable long employeeId) {
        Optional<EmployeeEntity> result = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployee() {
        List<EmployeeEntity> result = employeeService.getAllEmployee();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path = "/save", produces = "application/json")
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity result = employeeService.saveEmployee(employeeEntity);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
