package com.dailycodebuffer.springboot.tutorial.controller;


import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorial.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private final Logger LOGGER =LoggerFactory.getLogger(DepartmentController.class);

     @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        LOGGER.info("inside the saveDepartment ");
        return  departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentByID(id );
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id){
        departmentService.deleteDepartmentByID(id );
        return "Department deleted successfully!";

    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id,
                                   @RequestBody Department department){
        return departmentService.UpdateDepartmentByID(id,department );
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName );
    }

    @GetMapping("/departments/code/{code}")
    public Department fetchDepartmentByCode(@PathVariable("code") String departmentName){
        return departmentService.fetchDepartmentByCode(departmentName );
    }
}
