package com.parag.EmployeePayroll.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class  EmployeePayrollDTO {
	

	public EmployeePayrollDTO() {	}
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$" , message = "Please add valid name")
	public String name;
	
	@Min (value = 500 , message = "Min Wage should be 500")
	public long salary;
	
	@Pattern(regexp = "male|female" , message = "Please add valid gender (male/female) ")
	public String gender;
	
	@NotNull(message = "Date should not be empty ")
	@PastOrPresent(message = "start date should not be from future")
	@JsonFormat(pattern = "dd MMM yyyy")
	public LocalDate startDate;
	
	@NotBlank(message = "Note cannot be empty")
	public String note;
	
	@NotBlank(message = "Profile pic cant be empty")
	public String profilePic;
	
	@NotNull(message = "Department should not be empty")
	public List<String> department; 
	
	
	
	

	
	
	
}
