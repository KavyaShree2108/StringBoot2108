package com.example.demo.service;

import com.example.demo.doa.EmployeeDao;
import com.example.demo.entities.EmployeeDetailsDTO;
import com.example.demo.pojo.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


@org.springframework.stereotype.Service




public class ServiceImpl implements Service{
@Autowired
private EmployeeDao employeeDao;
    @Override
    public List<EmployeeDetailsDTO> getEmployees() {
        return employeeDao.findAll() ;
    }

    @Override
    public EmployeeDetailsDTO getEmployee(int id) {
        return employeeDao.getOne(id);
    }


    @Override
    public String addEmployee(EmployeeDetails employee) throws ParseException {
        EmployeeDetailsDTO employeeDetailsDTO = new EmployeeDetailsDTO();
        employeeDetailsDTO.setName(employee.getName());
        employeeDetailsDTO.setId(employee.getId());
        employeeDetailsDTO.setSalary(employee.getSalary());
        employeeDetailsDTO.setPhone_no(employee.getPhone_no());
        Date d = new SimpleDateFormat("mm-dd-yyyy").parse(employee.getDate());
        employeeDetailsDTO.setDate(d);
        int age = employee.getAge();
            if (age>=70){
            throw new AgeDoesNotExistsException("InvalidAge");
        }
        if (age <= 10) {
            employeeDetailsDTO.setStatus("kid");
        } else if (age >= 13 && age <= 19) {
            employeeDetailsDTO.setStatus("Adult");

        } else if (age >= 20 && age <= 40) {
            employeeDetailsDTO.setStatus("Citizen");
        } else if (age >= 60) {
            employeeDetailsDTO.setStatus("OldCitizen");
        }
        return "Successfully Saved";
    }

    @Override
    public EmployeeDetailsDTO updateEmployee(EmployeeDetailsDTO employee) {
        employeeDao.save(employee);
        return employee;
    }


    public EmployeeDetails findHighestSalary() {
        List<EmployeeDetailsDTO> list = employeeDao.findAll();

        Collections.sort(list, new Comparator<EmployeeDetailsDTO>() {
            @Override
            public int compare(EmployeeDetailsDTO o1, EmployeeDetailsDTO o2) {
              return (int) (o2.getSalary()-o1.getSalary());
            }
        });
        EmployeeDetailsDTO employeeDetailsDTO=list.get(0);
        EmployeeDetails employeeDetails=new EmployeeDetails();
        employeeDetails.setSalary(employeeDetailsDTO.getSalary());
        employeeDetails.setId(employeeDetailsDTO.getId());
        employeeDetails.setName(employeeDetailsDTO.getName());
        return employeeDetails;
    }

    }





