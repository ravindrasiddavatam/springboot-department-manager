package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;


public interface DepartmentService {


   public  Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

   public Optional<Department> fetchDepartById(Long departmentId) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long departmentId);

   public Department UpdateDepartment(Long departmentId, Department department);

   public Department fetchDepartmentByName(String departmentName);

   Object fetchDepartmentById(long l);
}
