package com.vti.testingassignment5.controller;

import com.vti.testingassignment5.entity.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vti.testingassignment5.service.IDepartmentService;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/departments")

public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @GetMapping()
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }

    @GetMapping(value="/{id}")
    public Department getDepartmentById(@PathVariable(name="id")short id){
        return service.getDepartmentById(id);
    }

    @GetMapping(value="/name/{name}")
    public Department getDepartmentByName(@PathVariable(name="name")String name){
        return service.getDepartmentByName(name);
    }

    @PostMapping()
    public void createDepartment(@RequestBody Department department){
        service.createDepartment(department);
    }

    @PutMapping(value = "/{id}")
    public void updateDepartment(@PathVariable(name="id") short id, @RequestBody Department department){
        department.setDepartmentId(id);
        service.updateDepartment(department);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteDepartment(@PathVariable(name="id") short id){
        service.deleteDepartment(id);
    }





}
