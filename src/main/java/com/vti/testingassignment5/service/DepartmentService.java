package com.vti.testingassignment5.service;

import com.vti.testingassignment5.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vti.testingassignment5.repository.IDepartmentRepository;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{
    @Autowired
    private IDepartmentRepository repository;

    public List<Department> getAllDepartments() {
        return repository.getAllDepartments();
    }
    public Department getDepartmentById(short id){
        return  repository.getDepartmentById(id);
    }

   public Department getDepartmentByName(String name){
        return  repository.getDepartmentByName(name);
    }

   public void createDepartment(Department department){
       repository.createDepartment(department);
   }

    public void updateDepartment(Department department){
        repository.updateDepartment(department);
    }


    public void deleteDepartment(short id){
        repository.deleteDepartment(id);
    }
}
