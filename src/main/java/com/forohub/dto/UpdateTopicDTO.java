package com.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateTopicDTO(
        @NotBlank(message = "El título no puede estar vacío") String title,
        @NotBlank(message = "El mensaje no puede estar vacío") String message
) {}
