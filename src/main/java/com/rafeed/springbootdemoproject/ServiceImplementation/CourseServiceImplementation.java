package com.rafeed.springbootdemoproject.ServiceImplementation;

import com.rafeed.springbootdemoproject.Entity.Course;
import com.rafeed.springbootdemoproject.Entity.Department;
import com.rafeed.springbootdemoproject.Exceptions.CourseNotFoundException;
import com.rafeed.springbootdemoproject.Exceptions.DepartmentNotFoundException;
import com.rafeed.springbootdemoproject.Repository.CourseRepository;
import com.rafeed.springbootdemoproject.Repository.DepartmentRepository;
import com.rafeed.springbootdemoproject.Service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImplementation implements CourseService {

    private CourseRepository courseRepository;
    private DepartmentRepository departmentRepository;

    public CourseServiceImplementation(CourseRepository courseRepository,
                                       DepartmentRepository departmentRepository) {
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        Course courseNew = courseRepository.getCourseByCourseName(course.getCourseName());
        if(courseNew != null){
            System.out.println("course already exits!");
        }
        else{
            String courseDepartmentName = course.getDepartment().getDepartmentName();
            Department courseDepartment = departmentRepository.findByDepartmentNameIgnoreCase(courseDepartmentName);
            if(courseDepartment != null){
                courseNew = course;
                courseNew.setDepartment(courseDepartment);
                courseRepository.save(courseNew);
            }
            else{
                courseNew = course;
                courseDepartment = course.getDepartment();
                courseNew.setDepartment(departmentRepository.save(courseDepartment));
                courseRepository.save(courseNew);
            }
        }
        return courseNew;
    }

    @Override
    public Course getCourse(int courseId) throws CourseNotFoundException {
        Course course = courseRepository.getCourseByCourseId(courseId);
        if(course == null){
            throw new CourseNotFoundException("Course not found!");
        }
        return course;
    }

    @Override
    public Course updateCourse(int courseId, Course course) throws CourseNotFoundException {
        Course courseUpdate = courseRepository.findById(courseId).get();
        Department courseDepartment = departmentRepository.getDepartmentByDepartmentId(course.getDepartment().getDepartmentId());

        if(courseUpdate != null && courseDepartment != null){
            courseUpdate.setCourseName(course.getCourseName());
            courseUpdate.setDepartment(course.getDepartment());
        }
        else{
            throw new CourseNotFoundException("Course not found!");
        }
        return courseRepository.save(courseUpdate);
    }

    @Override
    public void deleteCourse(int courseId) {
        Course courseDelete = courseRepository.getCourseByCourseId(courseId);
        courseRepository.delete(courseDelete);
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        return courseList;
    }

    @Override
    public Course getCourseByName(String courseName) throws CourseNotFoundException {
        Course course = courseRepository.getCourseByCourseName(courseName);
        if(course == null){
            throw new CourseNotFoundException("Course not found!!!");
        }
        return course;
    }
}
