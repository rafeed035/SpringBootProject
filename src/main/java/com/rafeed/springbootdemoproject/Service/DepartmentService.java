package com.rafeed.springbootdemoproject.Service;

import com.rafeed.springbootdemoproject.Entity.Department;
import com.rafeed.springbootdemoproject.Exceptions.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(int departmentId) throws DepartmentNotFoundException;
    void deleteDepartment(int departmentId) throws DepartmentNotFoundException;
    Department updateDepartment(int departmentId, Department department) throws DepartmentNotFoundException;
    Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException;
}
