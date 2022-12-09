package com.employee.EmployeeSystem.wrapper;


public class UserWrapper {
	
	private Integer id;
	
	private String ename;
	
	private String enumber;
	
	private String email;
	
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserWrapper(Integer id, String ename, String enumber, String email, String status) {
		super();
		this.id = id;
		this.ename = ename;
		this.enumber = enumber;
		this.email = email;
		this.status = status;
	}

}
