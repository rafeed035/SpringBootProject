package com.rafeed.springbootdemoproject.Service;

import com.rafeed.springbootdemoproject.Entity.Course;
import com.rafeed.springbootdemoproject.Exceptions.CourseNotFoundException;
import com.rafeed.springbootdemoproject.Exceptions.DepartmentNotFoundException;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);
    Course getCourse(int courseId) throws CourseNotFoundException;
    Course updateCourse(int courseId, Course course) throws DepartmentNotFoundException, CourseNotFoundException;
    void deleteCourse(int courseId);
    List<Course> getAllCourses();
    Course getCourseByName(String courseName) throws CourseNotFoundException;
}
