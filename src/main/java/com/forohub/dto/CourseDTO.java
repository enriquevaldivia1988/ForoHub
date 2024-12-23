package com.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record CourseDTO(
        @NotBlank(message = "El nombre del curso no puede estar vacío") String name,
        String description
) {}
