package com.niit.employeeinfo.service;
import java.util.List;

import com.niit.employeeinfo.model.Employee;

public interface EmployeeService {

	boolean addEmployeeInfo(Employee employee);
	List<Employee> getEmployeeInfoByCity(String city);
	boolean updateEmployeeInfo(Employee employee);
	boolean deleteEmployeeInfo(Employee employee);
	Long getEmployeeCountByDept(String dept);
	Long getEmployeeCountByCity(String city);
}
