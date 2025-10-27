package org.example.com.festival.dto

import jakarta.validation.constraints.NotBlank

data class UserAccountRegistrationDto(
    @field: NotBlank("Username is required")
    val username: String? = null,
    @field: NotBlank("Password is required")
    val password: String? = null
)

data class LoginRequestDto(
    val username: String,
    val password: String
)

data class LoginResponseDto(
    val username: String,
    val authenticated: Boolean
)