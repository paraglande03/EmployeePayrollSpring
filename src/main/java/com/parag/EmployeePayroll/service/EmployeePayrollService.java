package com.parag.EmployeePayroll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.parag.EmployeePayroll.dto.EmployeePayrollDTO;
import com.parag.EmployeePayroll.model.EmployeePayrollData;



@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList = new ArrayList<>();
		empDataList.add(new EmployeePayrollData(1, new EmployeePayrollDTO("Parag",60000)));
		return empDataList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		EmployeePayrollData empData = null;
		empData= new EmployeePayrollData(1, new EmployeePayrollDTO("Parag", 60000));
		return empData;
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=null;
		empData = new EmployeePayrollData(1, empPayrollDTO);
		
		return empData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
			EmployeePayrollData empData=null;
			empData = new EmployeePayrollData(1,employeePayrollDTO);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		
		
	}
	



}
