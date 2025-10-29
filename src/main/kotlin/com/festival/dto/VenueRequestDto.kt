package org.example.com.festival.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

// Equals, HashCode, ToString, ...
data class VenueRequestDto(
    @field:NotBlank
    val name: String? = null,

    @field:NotBlank
    val location: String? = null,

    @field: NotNull(message = "Capacity can't be null")
    @field:Min(1)
    val capacity: Int? = null,

    val userId: Long? = null
)