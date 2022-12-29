package com.employee.EmployeeSystem.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.EmployeeSystem.POJO.EmpLeave;
import com.employee.EmployeeSystem.constants.EmpConstants;
import com.employee.EmployeeSystem.dao.LeaveDao;
import com.employee.EmployeeSystem.service.LeaveService;
import com.employee.EmployeeSystem.utils.EmpUtils;

@Service
public class LeaveServiceImpl implements LeaveService{

	@Autowired
	LeaveDao leaveDao;
	
	@Override
	public ResponseEntity<String> addLeave(Map<String, String> requestMap) {
		try {
			if(validateLeaveMap(requestMap)) {
				//BeanUtils.copyProperties(EmpLeave, requestMap);
				leaveDao.save(getLeaveFromMap(requestMap));
				return EmpUtils.getResponseEntity("Leave Requested Successfully", HttpStatus.OK);
			}else {
				return EmpUtils.getResponseEntity(EmpConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return EmpUtils.getResponseEntity(EmpConstants.Something_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private EmpLeave getLeaveFromMap(Map<String, String> requestMap) {
		
		EmpLeave empLeave = new EmpLeave();
		empLeave.setId(Integer.parseInt(requestMap.get("id")));
		empLeave.setFromDate(requestMap.get("fromDate"));
		empLeave.setToDate(requestMap.get("toDate"));
		empLeave.setReason(requestMap.get("toDate"));
		empLeave.setStatus("New");
		return empLeave;
		
	}

	private boolean validateLeaveMap(Map<String, String> requestMap) {
		if(requestMap.containsKey("fromDate") && requestMap.containsKey("toDate") &&
				requestMap.containsKey("reason"))
			return true;
		return false;
	}

}
