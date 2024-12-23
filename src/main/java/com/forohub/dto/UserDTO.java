package com.forohub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank(message = "El nombre no puede estar vacío") String name,
        @Email(message = "El correo debe ser válido") @NotBlank(message = "El correo no puede estar vacío") String email,
        @NotBlank(message = "La contraseña no puede estar vacía") String password
) {}
