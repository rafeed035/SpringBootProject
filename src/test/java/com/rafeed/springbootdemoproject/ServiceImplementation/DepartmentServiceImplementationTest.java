package com.rafeed.springbootdemoproject.ServiceImplementation;

import com.rafeed.springbootdemoproject.Entity.Department;
import com.rafeed.springbootdemoproject.Repository.DepartmentRepository;
import com.rafeed.springbootdemoproject.Service.DepartmentService;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImplementationTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentId(1)
                .departmentName("CSE")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CSE"))
                .thenReturn(department);

        Mockito.when(departmentRepository.getDepartmentByDepartmentId(1)).thenReturn(department);
    }

    @Test
    @DisplayName(
            value = "Found Department for valid Department name"
    )
    public void whenValidDepartmentName_thenDepartmentShouldBeFound(){
        String departmentName = "CSE";
        Department departmentFound = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);

        assertEquals(departmentName, departmentFound.getDepartmentName());
    }

    @Test
    @DisplayName(
            value = "Found Department for valid Department id"
    )
    public void whenSearchedWithDepartmentId_thenDepartmentShouldBeFound(){
        int id = 1;
        Department departmentFound = departmentRepository.getDepartmentByDepartmentId(id);

        assertEquals(id, departmentFound.getDepartmentId());

    }


}