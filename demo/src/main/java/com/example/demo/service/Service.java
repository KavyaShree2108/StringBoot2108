package com.example.demo.service;

import com.example.demo.entities.EmployeeDetailsDTO;
import com.example.demo.pojo.EmployeeDetails;

import java.text.ParseException;
import java.util.List;

public interface Service {
    public List<EmployeeDetailsDTO> getEmployees();
    public EmployeeDetailsDTO getEmployee(int id);
    public String addEmployee(EmployeeDetails employee) throws ParseException;
    public EmployeeDetailsDTO updateEmployee(EmployeeDetailsDTO employee);
    public EmployeeDetails findHighestSalary();
}