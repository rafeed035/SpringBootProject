package com.rafeed.springbootdemoproject.Service;

import com.rafeed.springbootdemoproject.Entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(int departmentId);
    void deleteDepartment(int departmentId);
    Department updateDepartment(int departmentId, Department department);
    Department getDepartmentByName(String departmentName);
}
