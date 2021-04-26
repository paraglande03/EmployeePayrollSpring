package com.parag.EmployeePayroll.exceptions;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.parag.EmployeePayroll.dto.ResponseDTO;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {

		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){
			List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
			List<String> erroMessage = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
			
			ResponseDTO responseDTO = new ResponseDTO("Exception while processing Rest request", erroMessage);
			return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
			
			
		}
		
		@ExceptionHandler(EmployeePayrollException.class)
			public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception){
			ResponseDTO responseDTO = new ResponseDTO("Exception while Processing Rest request", exception.getMessage());
			return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(HttpMessageNotReadableException.class)
			public ResponseEntity<ResponseDTO> handleDateNotReadableException(HttpMessageNotReadableException exception){
			log.error("Invalid date format");
			String message = exception.getLocalizedMessage();
			ResponseDTO responseDTO = new ResponseDTO("Please Enter valid Date format", message );
			return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
		}
		
}
