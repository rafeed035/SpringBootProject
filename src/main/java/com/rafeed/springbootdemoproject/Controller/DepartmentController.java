package com.rafeed.springbootdemoproject.Controller;

import com.rafeed.springbootdemoproject.Entity.Department;
import com.rafeed.springbootdemoproject.Exceptions.DepartmentNotFoundException;
import com.rafeed.springbootdemoproject.Service.DepartmentService;
import com.rafeed.springbootdemoproject.ServiceImplementation.DepartmentServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping("/AllDepartments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/getDepartment")
    public Department getDepartmentById(@RequestParam int departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @GetMapping("/getDepartmentByName")
    public Department getDepartmentByName(@RequestParam String departmentName) throws DepartmentNotFoundException {
        return departmentService.getDepartmentByName(departmentName);
    }

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @DeleteMapping("/deleteDepartment")
    public String deleteDepartment(@RequestParam int departmentId) throws DepartmentNotFoundException {
        departmentService.deleteDepartment(departmentId);
        return "deleted successfully";
    }

    @PutMapping("/updateDepartment")
    public Department updateDepartment(@RequestParam int departmentId,
                                       @RequestBody Department department) throws DepartmentNotFoundException {
       return departmentService.updateDepartment(departmentId, department);
    }

}
