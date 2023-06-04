package dev.tharusha.wijayabahu.springcrud.controller;

import dev.tharusha.wijayabahu.springcrud.dto.EmployeeDTO;
import dev.tharusha.wijayabahu.springcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "{employeeId}", produces = "application/json")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable long employeeId) {
        EmployeeDTO result = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        List<EmployeeDTO> result = employeeService.getAllEmployee();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path = "/save", produces = "application/json")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        EmployeeDTO result = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
