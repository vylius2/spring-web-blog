package com.codeacademy.webapp.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class ProfileDTO {

    private Long id;

    @NotBlank(message = "Enter the username")
    @Size(min = 6, max = 30, message = "Username must be between 6-30 characters")
    private String username;

    @NotBlank(message = "Enter the password")
    private String password;

    @NotBlank(message = "Enter the email")
    private String email;

    @NotBlank(message = "Enter your name")
    private String firstName;

    private String lastName;

    private LocalDateTime createdAt;
}
