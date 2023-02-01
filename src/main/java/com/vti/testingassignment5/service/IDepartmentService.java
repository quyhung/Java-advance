package com.vti.testingassignment5.service;

import com.vti.testingassignment5.entity.Department;

import java.util.List;

public interface IDepartmentService {
   List<Department> getAllDepartments();
   Department getDepartmentById(short id);

   Department getDepartmentByName(String name);

   void createDepartment(Department department);

   void updateDepartment(Department department);


    void deleteDepartment(short id);
}
