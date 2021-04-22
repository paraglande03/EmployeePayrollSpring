package com.parag.EmployeePayroll.dto;

public class EmployeePayrollDTO {
	public String name;
	public long salary;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public EmployeePayrollDTO(String name, long salary) {
		
		this.name = name;
		this.salary = salary;
	}
	
	public EmployeePayrollDTO() {
		
		
	}
	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
	}
	
		
	
}
