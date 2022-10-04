package com.rafeed.springbootdemoproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
            nullable = false,
            unique = true
    )
    @NotBlank(
            message = "Please add Department Name"
    )
    private String departmentName;
}
