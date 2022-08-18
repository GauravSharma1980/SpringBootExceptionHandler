package com.exception.SpringBootExceptionHandler.service;


import com.exception.SpringBootExceptionHandler.exception.EmployeeServiceException;
import com.exception.SpringBootExceptionHandler.pojo.Employee;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryDependsOnPostProcessor;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  //returing employee object
  public Employee getEmployee() throws EmployeeServiceException {
    Employee employee = new Employee();
    employee.setName("gaurav");
    employee.setDesignation("Developer");
    employee.setEmpId("1");
    employee.setSalary(1000000);
    return employee;
  }

  public Employee getEmployeeNull() throws EmployeeServiceException
  {
    return  null;
  }

  public Employee getEmployeeException() throws EmployeeServiceException{
    throw new EmployeeServiceException();
  }

}
