package org.example.com.festival.dto

import jakarta.validation.constraints.NotBlank

data class PerformerRequestDto(
    @field:NotBlank
    val name: String? = null,

    @field:NotBlank
    val genre: String? = null,

    val about: String? = null,

    val userId: Long? = null
)