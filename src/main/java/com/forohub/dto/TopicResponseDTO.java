package com.forohub.dto;

import java.time.LocalDateTime;

public record TopicResponseDTO(
        String title,
        String message,
        LocalDateTime createdAt,
        String status,
        String authorName,
        String courseName
) {}
