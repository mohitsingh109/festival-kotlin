package org.example.com.festival.dto

import jakarta.validation.constraints.NotBlank
import org.example.com.festival.entity.Genre

data class PerformerResponseDto(
    @field:NotBlank
    val name: String? = null,

    @field:NotBlank
    val genre: Genre? = null,

    val about: String? = null,

    val userId: Long? = null
)