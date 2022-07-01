package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);


    List<Department> fetchDepartmentList();

    Department fetchDepartmentByID(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentByID(Long id);

    Department UpdateDepartmentByID(Long id, Department department);

    Department fetchDepartmentByName(String departmentName);

    Department fetchDepartmentByCode(String departmentName);
}
