package com.example.repository;

import com.example.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
    // SQL -> UPADTE emp_info SET empsalary=empsalary * 0.05 WHERE empcity=?
    //HQL -> UPDATE Employee SET salary=salary * 0.05 WHERE city=?
    //@NativeQuery
    @Modifying
    @Transactional(rollbackOn = {Exception.class})
    @Query(
value = "UPDATE emp_info SET empsalary=empsalary+empsalary * 0.05 WHERE empcity= :city",
    nativeQuery = true)
    public void updateEmpSalary(@Param("city") String city);

    @Modifying
    @Transactional
    @Query("DELETE FROM Employee WHERE city= :ct")
    //@Query(value = "DELETE FROM emp_info WHERE empcity= :ct", nativeQuery = true)
    public void deleteByCity(@Param("ct") String city) ;

    //@Query(value = "SELECT name, empsalary FROM emp_info",  nativeQuery = true)
    //@Query(value = "SELECT name, salary FROM Employee")
    //@Query(value = "FROM Employee")
    @Query(value = "SELECT  *  FROM emp_info", nativeQuery = true)
    List<Employee> selectEmpDetails();

}
