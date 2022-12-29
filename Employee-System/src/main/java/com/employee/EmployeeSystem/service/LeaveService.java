package com.employee.EmployeeSystem.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface LeaveService {

	ResponseEntity<String> addLeave(Map<String, String> requestMap);

}
