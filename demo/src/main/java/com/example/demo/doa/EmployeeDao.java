package com.example.demo.doa;

import com.example.demo.entities.EmployeeDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeDao extends JpaRepository<EmployeeDetailsDTO,Integer> {

}
