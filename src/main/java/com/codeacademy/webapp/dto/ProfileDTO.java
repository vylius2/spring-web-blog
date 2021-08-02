package com.codeacademy.webapp.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class ProfileDTO {

    private Long id;

    @NotEmpty(message = "Enter the username")
    @Size(min = 6, max = 30, message = "Username must be between 6-30 characters")
    private String username;

    @NotBlank(message = "Enter the password")
    @Size(min = 6, max = 18, message = "Password must be between 6-18 characters")
    @Pattern(regexp = "^.*(?=.*[a-z])(?=.*[A-Z]).*$", message = "Password must consist one or more lower or uppercase letter")
    private String password;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email address is not valid")
    @NotBlank(message = "Enter the email")
    private String email;

    @NotBlank(message = "Enter your name")
    private String firstName;

    private String lastName;

    private LocalDateTime createdAt;
}
