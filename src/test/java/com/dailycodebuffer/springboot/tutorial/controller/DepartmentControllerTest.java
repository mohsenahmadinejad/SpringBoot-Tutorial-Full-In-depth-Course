package com.dailycodebuffer.springboot.tutorial.controller;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp(){
        Department department=Department.builder().
                departmentName("IT").
                departmentAddress("TEHRAN").
                departmentCode("IT-06").
                 departmentId(1L).
                        build();
    }

    @Test
    void saveDepartment() {
        Department inputDepartment=Department.builder().
                departmentName("IT").
                departmentAddress("TEHRAN").
                departmentCode("IT-06").
                build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).
                thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post()
                .contentType(MediaType.APPLICATION_JSON)
                .content())
    }

    @Test
    void fetchDepartmentById() {
    }
}