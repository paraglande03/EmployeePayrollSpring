package com.parag.EmployeePayroll.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parag.EmployeePayroll.dto.EmployeePayrollDTO;
import com.parag.EmployeePayroll.exceptions.EmployeePayrollException;
import com.parag.EmployeePayroll.model.EmployeePayrollData;
import com.parag.EmployeePayroll.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
	
	@Autowired
	private EmployeePayrollRepository repository;
	

	

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return repository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return repository.findById(empId)
				.orElseThrow(()-> new EmployeePayrollException("Employee Not Found !"));
	}
	
	@Override
	public List<EmployeePayrollData> findEmployeesByDept(String department) {
		
		return repository.findEmployeesByDept(department);
	}
	

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=null;
		empData = new EmployeePayrollData(empPayrollDTO);
		
		log.debug("emp data: "+empData.toString());
		return 		repository.save(empData);

	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData( int empId, EmployeePayrollDTO employeePayrollDTO) {
			EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
			empData.updateEmployeePayrollData(employeePayrollDTO);
			return repository.save(empData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		repository.delete(empData);
		
	}

	
	
	



}
