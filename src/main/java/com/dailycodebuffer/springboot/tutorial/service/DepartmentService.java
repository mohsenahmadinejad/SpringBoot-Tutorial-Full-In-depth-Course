package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);


    List<Department> fetchDepartmentList();

    Department fetchDepartmentByID(Long id);

    void deleteDepartmentByID(Long id);

    Department UpdateDepartmentByID(Long id, Department department);

    Department fetchDepartmentByName(String departmentName);

    Department fetchDepartmentByCode(String departmentName);
}
