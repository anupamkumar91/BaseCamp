package com.midntree.entity;

import java.util.Date;

public class Employee {
	private int employeeNo;
	private String employeeName;
	private String email;
	private Date dateOfBirth;
	private double salary;

	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "employeeNo=" + employeeNo + ", employeeName=" + employeeName + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", salary=" + salary;
	}
}
