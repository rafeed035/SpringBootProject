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

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImplementation(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        //check whether the department exists or not
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
    public void deleteDepartment(int departmentId) throws DepartmentNotFoundException {
        //check whether the department exists or not
        Department deleteDepartment = departmentRepository.getDepartmentByDepartmentId(departmentId);
        if(deleteDepartment == null){
            throw new DepartmentNotFoundException("Department Not Found!");
        }
        else{
            departmentRepository.delete(deleteDepartment);
        }
    }

    @Override
    public Department updateDepartment(int departmentId, Department department) throws DepartmentNotFoundException {

        //check whether the department exists or not
        Department departmentCheck = departmentRepository.getDepartmentByDepartmentId(departmentId);

        if(departmentCheck != null){
            if(Objects.nonNull(department.getDepartmentName()) &&
                    !"".equalsIgnoreCase(department.getDepartmentName())){
                departmentCheck.setDepartmentName(department.getDepartmentName());
            }
        }
        else{
            throw new DepartmentNotFoundException("Department Not Found!");
        }

        return departmentRepository.save(departmentCheck);
    }

    @Override
    public Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException {
        //check whether the department exists or not
        Department department = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        if(department == null){
            throw new DepartmentNotFoundException("Department not found!!!");
        }
        return department;
    }
}
