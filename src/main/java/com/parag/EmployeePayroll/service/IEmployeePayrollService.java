package com.parag.EmployeePayroll.service;

import java.util.List;

import com.parag.EmployeePayroll.dto.EmployeePayrollDTO;
import com.parag.EmployeePayroll.model.EmployeePayrollData;

public interface IEmployeePayrollService {

		List<EmployeePayrollData> getEmployeePayrollData();
		
		EmployeePayrollData getEmployeePayrollDataById(int empId);
		
		EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
		
		EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO);
		
		void deleteEmployeePayrollData(int empId);
		
		List<EmployeePayrollData> findEmployeesByDept(String department);

}
