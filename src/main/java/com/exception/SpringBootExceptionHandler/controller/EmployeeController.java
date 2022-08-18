package com.exception.SpringBootExceptionHandler.controller;

import com.exception.SpringBootExceptionHandler.exception.EmployeeServiceException;
import com.exception.SpringBootExceptionHandler.exception.ResourceNotFoundException;
import com.exception.SpringBootExceptionHandler.pojo.Employee;
import com.exception.SpringBootExceptionHandler.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {


  @Autowired
  EmployeeService employeeService;

  //happy path scenario....
  @RequestMapping(value="/employee",method=RequestMethod.GET)
  public Employee getEmp() throws ResourceNotFoundException, EmployeeServiceException {
    try {
      Employee employee = employeeService.getEmployee();
      if (employee == null) {
        throw new ResourceNotFoundException("employee not found.....");
      }
      return employee;
    } catch (EmployeeServiceException e) {
        throw new EmployeeServiceException("not found....");
    }
  }
    //no employee found hence ResourceNotFoundException raised...

    @RequestMapping(value="/employee2",method=RequestMethod.GET)
       public Employee getEmp2() throws ResourceNotFoundException, EmployeeServiceException {
      try {
        Employee employee = employeeService.getEmployeeNull();
        if (employee == null) {
          throw new ResourceNotFoundException("Employee with null value not found...");
        }
        return employee;
      } catch (EmployeeServiceException ese) {
        throw new EmployeeServiceException("Internal Server Error");
      }
    }
}
