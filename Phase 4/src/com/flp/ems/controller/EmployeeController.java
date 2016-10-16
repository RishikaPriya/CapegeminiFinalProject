package com.flp.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.flp.ems.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	IEmployeeService empService;
	
	
}
