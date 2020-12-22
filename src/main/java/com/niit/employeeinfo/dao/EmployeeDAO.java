package com.niit.employeeinfo.dao;

import java.util.List;

import com.niit.employeeinfo.model.Employee;

public interface EmployeeDAO
{

	boolean addEmployeeInfo(Employee employee);
	List<Employee> getEmployeeInfoByCity(String city);
	Long getEmployeeCountByDept(String dept);
	Long getEmployeeCountByCity(String city);
	boolean updateEmployeeInfo(Employee employee);
	boolean deleteEmployeeInfo(Employee employee);
}
