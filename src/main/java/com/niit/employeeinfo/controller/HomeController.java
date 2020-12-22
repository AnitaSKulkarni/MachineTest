package com.niit.employeeinfo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee-info/api")
public class HomeController {
	@ResponseBody
	@RequestMapping("/")
	public Map<String, Object> test() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("result", "Welcome to employee Service");
		return map;
	}
}
