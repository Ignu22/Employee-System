package com.employee.EmployeeSystem.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.employee.EmployeeSystem.constants.EmpConstants;
import com.employee.EmployeeSystem.rest.LeaveRest;
import com.employee.EmployeeSystem.service.LeaveService;
import com.employee.EmployeeSystem.utils.EmpUtils;

@RestController
public class LeaveRestImpl implements LeaveRest{

	@Autowired
	LeaveService leaveservice;
	
	@Override
	public ResponseEntity<String> addLeave(Map<String, String> requestMap) {
		try {
			return leaveservice.addLeave(requestMap);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return EmpUtils.getResponseEntity(EmpConstants.Something_Wrong, HttpStatus.INTERNAL_SERVER_ERROR); 
	}

}
