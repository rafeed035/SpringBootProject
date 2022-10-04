package com.rafeed.springbootdemoproject.ExceptionHandler;

import com.rafeed.springbootdemoproject.Entity.CourseErrorMessage;
import com.rafeed.springbootdemoproject.Entity.DepartmentErrorMessage;
import com.rafeed.springbootdemoproject.Exceptions.CourseNotFoundException;
import com.rafeed.springbootdemoproject.Exceptions.DepartmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<DepartmentErrorMessage> departmentNotFoundException(DepartmentNotFoundException departmentNotFoundException,
                                                                              WebRequest webRequest){
        DepartmentErrorMessage departmentErrorMessage = new DepartmentErrorMessage(HttpStatus.NOT_FOUND,
                departmentNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(departmentErrorMessage);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<CourseErrorMessage> courseNotFoundException(CourseNotFoundException courseNotFoundException,
                                                                      WebRequest webRequest){
        CourseErrorMessage courseErrorMessage = new CourseErrorMessage(HttpStatus.NOT_FOUND,
                courseNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(courseErrorMessage);
    }
}
