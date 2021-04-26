package com.parag.EmployeePayroll.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.parag.EmployeePayroll.dto.EmployeePayrollDTO;

import lombok.Data;

@Entity
@Table (name = "employee_payroll")
public @Data class EmployeePayrollData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private int employeeId;
	
	
	private String name;
	private long salary;
	public String gender;
	public LocalDate startDate;
	public String note;
	public String profilePic;
	
	
	@ElementCollection
	@CollectionTable(name = "employee_department" , joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	public List<String> department; 

	  public EmployeePayrollData() { }
	
	
	  public EmployeePayrollData( EmployeePayrollDTO empPayrollDTO) {
	  
	  this.updateEmployeePayrollData(empPayrollDTO);
	  
	  }
	 
	  public void updateEmployeePayrollData(EmployeePayrollDTO dto) {
		  this.name = dto.name; 
		  this.salary = dto.salary; 
		  this.gender=dto.gender;
		  this.startDate=dto.startDate;
		  this.note=dto.note;
		  this.profilePic=dto.profilePic;
		  this.department=dto.department;
		  
		  
	  }



	



}