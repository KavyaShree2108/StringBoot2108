package com.example.demo.service;

import com.example.demo.doa.EmployeeDao;
import com.example.demo.entities.EmployeeDetailsDTO;
import com.example.demo.pojo.EmployeeDetails;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@ExtendWith(SpringExtension.class)
class ServiceImplTest {
    @Mock
    private EmployeeDao employeedoa;

    @InjectMocks
    private ServiceImpl employeeservice;
    List<EmployeeDetailsDTO> employeeDetailsDTOList;

    @BeforeEach
    void getEmployees() {
        employeeDetailsDTOList = new ArrayList<>();
        EmployeeDetailsDTO employeeDetailsDTO = new EmployeeDetailsDTO();
        employeeDetailsDTO.setName("BBY");
        employeeDetailsDTOList.add(employeeDetailsDTO);
    }

    @Test
    void addEmployee() throws ParseException {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setId(3);
        employeeDetails.setName("KS");
        employeeDetails.setPhone_no(7019941);
        employeeDetails.setSalary(1000);
        employeeDetails.setAge(180);
        employeeDetails.setDate("01-04-1998");

    }
    @Test
    public void Exception_handler(){
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setId(4);
        employeeDetails.setName("S");
        employeeDetails.setPhone_no(7019941);
        employeeDetails.setSalary(1000);
        employeeDetails.setAge(180);
        employeeDetails.setDate("01-04-1998");
        Exception exception=assertThrows(AgeDoesNotExistsException.class, ()->
        {
            log.info("kabya");
            employeeservice.addEmployee(employeeDetails);

        });
        String expected="InvalidAge";
        String actual=exception.getMessage();
        assertTrue(actual.contains(expected));
    }

}