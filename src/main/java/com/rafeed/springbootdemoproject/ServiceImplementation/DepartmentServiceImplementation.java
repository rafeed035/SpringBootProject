package com.rafeed.springbootdemoproject.ServiceImplementation;

import com.rafeed.springbootdemoproject.Entity.Department;
import com.rafeed.springbootdemoproject.Repository.DepartmentRepository;
import com.rafeed.springbootdemoproject.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        return departmentRepository.getDepartmentByDepartmentId(departmentId);
    }

    @Override
    public void deleteDepartment(int departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(int departmentId, Department department) {
        Department departmentUpdate = departmentRepository.getDepartmentByDepartmentId(departmentId);
        if(departmentUpdate != null){
            departmentUpdate.setDepartmentName(department.getDepartmentName());
            departmentUpdate.setDepartmentAddress(department.getDepartmentAddress());
            departmentUpdate.setDepartmentCode(department.getDepartmentCode());
        }
        else{
            System.out.println("no object!");
        }
        return departmentRepository.save(departmentUpdate);
    }


}
