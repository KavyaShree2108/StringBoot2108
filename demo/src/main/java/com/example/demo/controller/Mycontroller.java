package com.example.demo.controller;

import com.example.demo.entities.EmployeeDetailsDTO;
import com.example.demo.pojo.EmployeeDetails;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class Mycontroller {
    @Autowired
    private Service service;
    @GetMapping("/emp")
    public List<EmployeeDetailsDTO> getEmployees() {
        return this.service.getEmployees();
    }
@GetMapping("/emp/{empID}")
    public EmployeeDetailsDTO getEmployee(int id){
        return this.service.getEmployee(id);
}
@PostMapping("/createEmployee")
public  String addEmployee(@RequestBody EmployeeDetails employee) throws ParseException{
        return this.service.addEmployee(employee);
}
@PutMapping("/emp")
public  EmployeeDetailsDTO updateEmployee(@RequestBody EmployeeDetailsDTO employee){
        return  this.service.updateEmployee(employee);

}
@GetMapping("/findHighestSalary")
public EmployeeDetails findHighestSalary(){
        return this.service.findHighestSalary();

    }

}
