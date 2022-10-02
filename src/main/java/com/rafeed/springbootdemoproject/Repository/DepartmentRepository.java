package com.rafeed.springbootdemoproject.Repository;

import com.rafeed.springbootdemoproject.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department getDepartmentByDepartmentId(int departmentId);
}
