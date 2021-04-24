package com.parag.EmployeePayroll.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parag.EmployeePayroll.dto.EmployeePayrollDTO;
import com.parag.EmployeePayroll.dto.ResponseDTO;
import com.parag.EmployeePayroll.model.EmployeePayrollData;
import com.parag.EmployeePayroll.service.IEmployeePayrollService;



@RequestMapping("/employeepayrollservice")
@RestController
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService service;

	@RequestMapping({"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
		List<EmployeePayrollData> empDataList= null;
		empDataList=service.getEmployeePayrollData();
		ResponseDTO responseDTO= new ResponseDTO("Get call Successful", empDataList);
				return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId")int empId){
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData = service.getEmployeePayrollDataById(empId);
		ResponseDTO responseDTO = new ResponseDTO("Get call for Id "+ empId+" Successful", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployyePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=service.createEmployeePayrollData(empPayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Creattion Successful", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable ("empId")int empId,@Valid@RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData= service.updateEmployeePayrollData(empId,empPayrollDTO);
		ResponseDTO responseDTO= new ResponseDTO("Updated!", employeePayrollData);
		return new ResponseEntity<ResponseDTO> (responseDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
		service.deleteEmployeePayrollData(empId);
		ResponseDTO responseDTO = new ResponseDTO("Deleted", empId);
		return new ResponseEntity<ResponseDTO>( responseDTO,HttpStatus.OK);
	}
}
