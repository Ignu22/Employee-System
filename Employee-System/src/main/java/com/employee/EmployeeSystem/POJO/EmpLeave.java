package com.employee.EmployeeSystem.POJO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@NamedQuery(name="EmpLeave.getLeave",query="Select e from EmpLeave e")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="empleave")
public class EmpLeave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	public EmpLeave() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="fromDate")
	private String fromDate;
	
	public EmpLeave(Integer id, String fromDate, String toDate, String reason, String status) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reason = reason;
		this.status = status;
	}

	@Column(name="toDate")
	private String toDate;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="reason")
	private String reason;
	
	@Column(name="status")
	private String status;
	
	

}
