package com.rafeed.springbootdemoproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentErrorMessage {
    private HttpStatus status;
    private String message;
}
