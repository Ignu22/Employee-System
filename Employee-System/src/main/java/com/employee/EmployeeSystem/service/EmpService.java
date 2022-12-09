package com.employee.EmployeeSystem.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.employee.EmployeeSystem.wrapper.UserWrapper;

public interface EmpService {
	
	ResponseEntity<String> signUp(Map<String, String> requestMap);
	
	ResponseEntity<String> login(Map<String, String> requestMap);
	
	ResponseEntity<List<UserWrapper>> getAllUser();
	
	ResponseEntity<String> update(Map<String, String> requestMap);

}
