package com.rafeed.springbootdemoproject.Repository;

import com.rafeed.springbootdemoproject.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course getCourseByCourseId(int courseId);
    Course getCourseByCourseName(String courseName);
}
