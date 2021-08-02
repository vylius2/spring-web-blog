package com.codeacademy.webapp.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class PostDTO {

    private Long id;

    @NotBlank(message = "Enter the title!")
    private String title;

    @Size(min = 10, message = "Article must consist at least 10 symbols!")
    private String text;

    private LocalDateTime createdAt;
}
