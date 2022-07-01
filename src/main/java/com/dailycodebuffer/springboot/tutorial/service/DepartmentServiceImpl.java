package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl  implements DepartmentService{

   @Autowired
   private  DepartmentRepository departmentRepository;

   @Override
   public Department saveDepartment(Department department) {
      return departmentRepository.save(department);
   }

   @Override
   public List<Department> fetchDepartmentList() {
      return departmentRepository.findAll();
   }

   @Override
   public Department fetchDepartmentByID(Long id) throws DepartmentNotFoundException {
      Optional<Department> department= departmentRepository.findById(id);

      if(!department.isPresent()){
         throw  new DepartmentNotFoundException("Department is not available");
      }
      return department.get();
   }

   @Override
   public void deleteDepartmentByID(Long id) {
      departmentRepository.deleteById(id);
   }

   @Override
   public Department UpdateDepartmentByID(Long id, Department department) {
      Department depDB=departmentRepository.findById(id).get();

      if(Objects.nonNull(department.getDepartmentName() ) &&
              !"".equalsIgnoreCase(department.getDepartmentName())){
         depDB.setDepartmentName(department.getDepartmentName() );
      }
      if(Objects.nonNull(department.getDepartmentCode() ) &&
              !"".equalsIgnoreCase(department.getDepartmentCode())){
         depDB.setDepartmentCode(department.getDepartmentCode() );
      }
      if(Objects.nonNull(department.getDepartmentAddress() ) &&
              !"".equalsIgnoreCase(department.getDepartmentAddress())){
         depDB.setDepartmentAddress(department.getDepartmentAddress() );
      }


      return departmentRepository.save(depDB);
   }

   @Override
   public Department fetchDepartmentByName(String departmentName) {
      return  departmentRepository.findByDepartmentName(departmentName);
   }

   @Override
   public Department fetchDepartmentByCode(String departmentCode) {
      return departmentRepository.getDepartmentByDepartmentCode(departmentCode);
   }

}
