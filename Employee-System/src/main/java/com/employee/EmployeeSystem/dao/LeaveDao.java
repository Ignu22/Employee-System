package com.employee.EmployeeSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.EmployeeSystem.POJO.EmpLeave;

public interface LeaveDao extends JpaRepository<EmpLeave, Integer>{

	List<EmpLeave> getLeave();
	
}
