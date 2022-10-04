package com.rafeed.springbootdemoproject.Controller;

import com.rafeed.springbootdemoproject.Entity.Course;
import com.rafeed.springbootdemoproject.Exceptions.CourseNotFoundException;
import com.rafeed.springbootdemoproject.Exceptions.DepartmentNotFoundException;
import com.rafeed.springbootdemoproject.Service.CourseService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/saveCourse")
    public Course saveCourse(@Valid @RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @GetMapping("/getCourseById")
    public Course getCourseById(@RequestParam int courseId) throws CourseNotFoundException {
        return courseService.getCourse(courseId);
    }

    @GetMapping("/getCourseByName")
    public Course getCourseByName(@RequestParam String courseName) throws CourseNotFoundException {
        return courseService.getCourseByName(courseName);
    }

    @PutMapping("/updateCourse")
    public Course updateCourse(@RequestParam int courseId, @Valid @RequestBody Course course) throws CourseNotFoundException, DepartmentNotFoundException {
        return courseService.updateCourse(courseId, course);
    }

    @GetMapping("/getAllCourses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @DeleteMapping("/deleteCourse")
    public String deleteCourse(@RequestParam int courseId){
        courseService.deleteCourse(courseId);
        return "deleted";
    }

}
