package com.vti.testingassignment5.repository;

import com.vti.testingassignment5.entity.Department;

import java.util.List;

public interface IDepartmentRepository {
    List<Department> getAllDepartments();

    Department getDepartmentById(short id);

    Department getDepartmentByName(String name);

    void createDepartment(Department department);

    void updateDepartment(Department department);


     void deleteDepartment(short id);
}
