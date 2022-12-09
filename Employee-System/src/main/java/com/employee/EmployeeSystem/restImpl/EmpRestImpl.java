package com.employee.EmployeeSystem.restImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.employee.EmployeeSystem.constants.EmpConstants;
import com.employee.EmployeeSystem.rest.EmpRest;
import com.employee.EmployeeSystem.service.EmpService;
import com.employee.EmployeeSystem.utils.EmpUtils;
import com.employee.EmployeeSystem.wrapper.UserWrapper;

@RestController
public class EmpRestImpl implements EmpRest{
	
	@Autowired
	EmpService empservice;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		
		
		try {
			return empservice.signUp(requestMap);
			
		}catch( Exception ex){
			
			ex.printStackTrace();
			
		}
		return EmpUtils.getResponseEntity(EmpConstants.Something_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		
		try {
			
			return empservice.login(requestMap);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return EmpUtils.getResponseEntity(EmpConstants.Something_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<UserWrapper>> getAllUser() {
		try {
			return empservice.getAllUser();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<List<UserWrapper>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> update(Map<String, String> requestMap) {
		try {
			return empservice.update(requestMap);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return EmpUtils.getResponseEntity(EmpConstants.Something_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
