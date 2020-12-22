package com.niit.employeeinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.employeeinfo.dao.EmployeeDAO;
import com.niit.employeeinfo.model.Employee;
import com.niit.employeeinfo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public boolean addEmployeeInfo(Employee employee) {
		if(employeeDAO.addEmployeeInfo(employee))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<Employee> getEmployeeInfoByCity(String city) {
		List<Employee> employee=employeeDAO.getEmployeeInfoByCity(city);
		if(employee!=null)
		{
			return employee;
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean updateEmployeeInfo(Employee employee) {
		if(employeeDAO.updateEmployeeInfo(employee))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteEmployeeInfo(Employee employee) {
		if(employeeDAO.deleteEmployeeInfo(employee))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Long getEmployeeCountByDept(String dept) {
		return employeeDAO.getEmployeeCountByDept(dept);
	}

	@Override
	public Long getEmployeeCountByCity(String city) {
		return employeeDAO.getEmployeeCountByCity(city);
	}

}
