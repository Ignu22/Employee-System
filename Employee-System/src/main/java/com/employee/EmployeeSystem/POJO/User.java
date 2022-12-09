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


@NamedQuery(name = "User.findByEmailId",query="select u from User u where u.email=:email")

@NamedQuery(name = "User.getAllUser",query= "select new com.employee.EmployeeSystem.wrapper.UserWrapper(u.id,u.ename,u.enumber,u.email,u.status) from User u where u.role='user'")

@NamedQuery(name = "User.updateStatus", query="Update User u set u.status=:status where u.id=:id")

@NamedQuery(name = "User.getAllAdmin",query= "select u.email from User u where u.role='admin'")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="employee")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static final long serialVersiionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEnumber() {
		return enumber;
	}

	public void setEnumber(String enumber) {
		this.enumber = enumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="name")
	private String ename;
	
	@Column(name="c.no.")
	private String enumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private String status;
	
	public String getStatus() {
		return status;
	}

	public User(Integer id, String ename, String enumber, String email, String password, String status, String role) {
		super();
		this.id = id;
		this.ename = ename;
		this.enumber = enumber;
		this.email = email;
		this.password = password;
		this.status = status;
		this.role = role;
	}

	public User() {
		
		// TODO Auto-generated constructor stub
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="role")
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
