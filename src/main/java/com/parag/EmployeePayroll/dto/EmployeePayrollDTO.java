package com.parag.EmployeePayroll.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {
	
	
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$" , message = "Please add valid name")
	public String name;
	
	@Min (value = 500 , message = "Min Wage should be 500")
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
