package com.rafeed.springbootdemoproject.ServiceImplementation;

import com.rafeed.springbootdemoproject.Entity.Department;
import com.rafeed.springbootdemoproject.Exceptions.DepartmentNotFoundException;
import com.rafeed.springbootdemoproject.Repository.DepartmentRepository;
import com.rafeed.springbootdemoproject.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        Department checkDepartment = departmentRepository.findByDepartmentNameIgnoreCase(department.getDepartmentName());
        if(checkDepartment != null){
            System.out.println("\nDepartment already exists!!!");
        }
        else{
            checkDepartment = departmentRepository.save(department);
        }
        return checkDepartment;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(int departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found!");
        }
        return department.get();
    }

    @Override
    public void deleteDepartment(int departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(int departmentId, Department department) {
        Department departmentUpdate = departmentRepository.getDepartmentByDepartmentId(departmentId);

        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentUpdate.setDepartmentName(department.getDepartmentName());
        }
        return departmentRepository.save(departmentUpdate);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
