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
public class Course {
    @Id
    @Column(
            name = "course_id",
            nullable = false
    )
    @SequenceGenerator(
            name = "course_id_sequence",
            sequenceName = "course_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "course_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int courseId;

    @Column(
            name = "course_name",
            nullable = false,
            unique = true
    )
    @NotBlank(
            message = "Please add course name"
    )
    private String courseName;

    @ManyToOne(
    )
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "department_id"
    )
    private Department department;
}
