package com.example.controller;

import com.example.entity.Employee;
import com.example.mode.EmpData;
import com.example.mode.EmpPartialData;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @PostMapping("/save-emp")
    public String saveEmp(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return "Employee Save Successfully";
    }
    @PatchMapping("/update-salary/{city}")
    public String updateSalary(@PathVariable("city") String city) {
        employeeRepository.updateEmpSalary(city);
        return "Salary Updated Successfully";
    }
    @DeleteMapping("/delete-by-city/{city}")
    public String delete(@PathVariable("city") String city) {
        employeeRepository.deleteByCity(city);
        return "DELETED Successfully";
    }
    @GetMapping("/get-emp")
    public List<EmpData> getEmp() {
        return employeeRepository.selectEmpDetails();
    }
    @GetMapping("/get-emp-partial-data")
    public List<EmpPartialData> getEmppartialData() {
        return employeeRepository.getEmoData();
    }
}
