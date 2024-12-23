package com.forohub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDTO(
        @NotBlank(message = "El título no puede estar vacío") String title,
        @NotBlank(message = "El mensaje no puede estar vacío") String message,
        @NotNull(message = "El autor no puede estar vacío") Long authorId,
        @NotNull(message = "El curso no puede estar vacío") Long courseId
) {}
