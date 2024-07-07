package com.dailycodebuffer.Springboot.tutorial.controller;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;



    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

@PostMapping("/departments")
public Department saveDepartment(@Valid @RequestBody Department department) {
    LOGGER.info("Inside saveDepartment of DepartmentController");
    return departmentService.saveDepartment(department);


}

@GetMapping("/departments")
public List<Department> fetchDepartmentList(){
    LOGGER.info("Inside fetchDepartmentList of DepartmentController");
    return departmentService.fetchDepartmentList();
}

@GetMapping("/departments/{id}")
public Optional<Department> fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
    return departmentService.fetchDepartById(departmentId);
}

@DeleteMapping("/departments/{id}")
public String deleteDepartmentById(@PathVariable("id") Long departmentId){
    departmentService.deleteDepartmentById(departmentId);
    return "Department deleted successfully!!!";
}

@PutMapping("/departments/{id}")
public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
    return departmentService.UpdateDepartment(departmentId,department);
}

@GetMapping("/departments/name/{name}")
public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
    return departmentService.fetchDepartmentByName(departmentName);
}
}
