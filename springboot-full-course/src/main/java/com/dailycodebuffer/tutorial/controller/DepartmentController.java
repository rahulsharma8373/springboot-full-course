package com.dailycodebuffer.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.tutorial.entity.Department;
import com.dailycodebuffer.tutorial.service.DepartmentService;


@RestController
class DepartmentController {
	
	@Autowired
	private  DepartmentService departmentService;
	
	//  private static final Logger logger = (Logger) LoggerFactory.logger(DepartmentController.class);
	
	
	//save
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		//logger.info("inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	//list 
	@GetMapping("/department")
	public List<Department> fetchDepartmentList(){
	//	logger.info("inside fetchDepartment of DepartmentController");
		
		return departmentService.fetchDepartmentList();
	}
	//fetchById
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable ("id") Long departmentId) {
		return departmentService.fetchDepartmentById(departmentId);
	}
	//delete
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable ("id") Long departmentId) {	  
		departmentService.deleteDepartmentById(departmentId);
		return "deleted successfully";
		
	}
	@PutMapping("/update/{id}")
	public Department updateDepartment(@PathVariable("id")Long departmentId,@RequestBody Department department) {
		return departmentService.updateDepartment(departmentId, department);
		
	}

	@GetMapping("/department/name/{name}")
	public Department fetchDepartmentByName(@PathVariable ("name")  String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
		
	}
	
	
	
	
	
	
	
	
	
}