package com.niit.employeeinfo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.employeeinfo.model.Employee;
import com.niit.employeeinfo.service.EmployeeService;

@RestController
@RequestMapping("/employee-info/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@ResponseBody
	@RequestMapping("/city/{city}")
	public Long getEmployeeInfoByCity(@PathVariable("city") String city)
	{
		
		return employeeService.getEmployeeCountByCity(city);
	}
	
	
	@ResponseBody
	@RequestMapping("/dept/{department}")
	public Long getEmployeeInfoByDept(@PathVariable("department") String dept)
	{
		return employeeService.getEmployeeCountByDept(dept);
	}
	

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Map<String, Object> addEmployee(@RequestBody Employee employee)
	{
		Map<String, Object> map = new LinkedHashMap<>();
		if(employeeService.addEmployeeInfo(employee))
		{
			map.put("result", "Added");
		}
		else
		{
			map.put("result", "Error While Adding Employee Information!! Please Check Console for further details...");
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Map<String, Object> updateEmployee(@RequestBody Employee employee)
	{
		Map<String, Object> map = new LinkedHashMap<>();
		if(employeeService.updateEmployeeInfo(employee))
		{
			map.put("result", "Updated");
		}
		else
		{
			map.put("result", "Error While Updating Employee Information!! Please Check Console for further details...");
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Map<String, Object> deleteEmployee(@RequestBody Employee employee)
	{
		Map<String, Object> map = new LinkedHashMap<>();
		if(employeeService.deleteEmployeeInfo(employee))
		{
			map.put("result", "Deleted");
		}
		else
		{
			map.put("result", "Error While Deleting Employee Information!! Please Check Console for further details...");
		}
		return map;
	}
}
