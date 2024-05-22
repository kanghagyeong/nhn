package com.nhnacademy.student.domain;

import jakarta.validation.constraints.*;
import lombok.Value;


@Value
public class StudentRequest {
    String id;
    String password;

    @NotBlank
    String name;

    @Email
    String email;

    @Min(0)
    @Max(100)
    int score;

    @NotBlank
    @Size(min = 0, max = 200)
    String comment;
}
