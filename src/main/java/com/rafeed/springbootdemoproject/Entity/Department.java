package com.rafeed.springbootdemoproject.Entity;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @Column(
            name = "department_id",
            nullable = false
    )
    @SequenceGenerator(
            name = "department_id_sequence",
            sequenceName = "department_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "department_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int departmentId;

    @Column(
            name = "department_name",
            nullable = false
    )
    private String departmentName;

    @Column(
            name = "department_address",
            nullable = false
    )
    private String departmentAddress;

    @Column(
            name = "department_code",
            nullable = false
    )
    private String departmentCode;

    public Department() {
    }

    public Department(int departmentId,
                      String departmentName,
                      String departmentAddress,
                      String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }
}
