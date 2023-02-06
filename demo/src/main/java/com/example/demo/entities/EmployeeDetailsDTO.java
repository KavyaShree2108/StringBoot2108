package com.example.demo.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class EmployeeDetailsDTO{
    @Id
    private int id;
    private String name;
    private long phone_no;
    private int age;
    private long salary;
    private Date date;

    private String status;
}
