package com.employee.EmployeeSystem.serviceImpl;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.employee.EmployeeSystem.JWT.EmpDetailsService;
import com.employee.EmployeeSystem.JWT.JwtFilter;
//import com.employee.EmployeeSystem.JWT.JwtFilter;
import com.employee.EmployeeSystem.JWT.JwtUtil;
import com.employee.EmployeeSystem.POJO.User;
import com.employee.EmployeeSystem.constants.EmpConstants;
import com.employee.EmployeeSystem.dao.UserDao;
import com.employee.EmployeeSystem.service.EmpService;
import com.employee.EmployeeSystem.utils.EmailUtils;
import com.employee.EmployeeSystem.utils.EmpUtils;
import com.employee.EmployeeSystem.wrapper.UserWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	EmpDetailsService empDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Autowired
	EmailUtils emailUtils;
	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {

		//log.info("Inside signup {}",requestMap);

		try {
			if(validateSignUpMap(requestMap)) {
				
				User user= userDao.findByEmailId(requestMap.get("email"));
				if(Objects.isNull(user)) {
					
					userDao.save(getUserFromMap(requestMap));
					return EmpUtils.getResponseEntity("Successfully registered.", HttpStatus.OK);
					
				}else {
					return EmpUtils.getResponseEntity("Email already exist",HttpStatus.BAD_REQUEST);
				}
				
			}
			else {
				return EmpUtils.getResponseEntity(EmpConstants.INVALID_DATA,HttpStatus.BAD_REQUEST);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return EmpUtils.getResponseEntity(EmpConstants.Something_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if(requestMap.containsKey("ename") && requestMap.containsKey("enumber") && requestMap.containsKey("email")
				&& requestMap.containsKey("password")) {
			return true;
		}
		return false;
	}
	         
	private User getUserFromMap(Map<String,String>requestMap) {
		
		User user= new User();
		user.setEname(requestMap.get("name"));
		user.setEnumber(requestMap.get("contactNumber"));
		user.setEmail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setStatus("false");
		user.setRole("user");
		return user;
	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		
		try {
			
			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password")));
			
			if(auth.isAuthenticated()) {
				if(empDetailsService.getUserDetail().getStatus().equalsIgnoreCase("true")) {
					return new ResponseEntity<String>("{\"token\":\""+jwtUtil.generateToken(empDetailsService.getUserDetail().getEmail(),
							empDetailsService.getUserDetail().getRole())+"\"}",HttpStatus.OK);
				}else {
					return new ResponseEntity<String>("{\"message\":\""+"Wait for admin approval "+"\"}",HttpStatus.BAD_REQUEST);
				}
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("{\"message\":\""+"Bad Credential "+"\"}",HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<UserWrapper>> getAllUser() {
		try {
			if(jwtFilter.isAdmin()) {
				return  new ResponseEntity<>(userDao.getAllUser(),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(new ArrayList<>(),HttpStatus.UNAUTHORIZED);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> update(Map<String, String> requestMap) {
		try {
			if(jwtFilter.isAdmin()) {
				Optional<User> optional = userDao.findById(Integer.parseInt(requestMap.get("id")));
				if(!optional.isEmpty()) {
					userDao.updateStatus(requestMap.get("status"),Integer.parseInt(requestMap.get("id")));
					sendMailToAllAdmin(requestMap.get("status"),optional.get().getEmail(),userDao.getAllAdmin()); 	
					return EmpUtils.getResponseEntity("User Status Updated Successfully", HttpStatus.OK);
				}else {
					return EmpUtils.getResponseEntity("User id doesn't exist", HttpStatus.OK);
				}
				
			}else {
				return EmpUtils.getResponseEntity(EmpConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return EmpUtils.getResponseEntity(EmpConstants.Something_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private void sendMailToAllAdmin(String string, String email, List<String> allAdmin) {

		allAdmin.remove(jwtFilter.getCurrentUser());
		if(status !=null && status.equalsIgnoreCase("true")) {
			
		}
	}
	
	

}
