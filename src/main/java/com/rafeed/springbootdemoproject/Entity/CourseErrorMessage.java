package com.rafeed.springbootdemoproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseErrorMessage {
    private HttpStatus httpStatus;
    private String message;
}
