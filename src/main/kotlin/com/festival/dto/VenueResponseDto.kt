package org.example.com.festival.dto

data class VenueResponseDto(
    val id: Long,
    val name: String,
    val location: String,
    val capacity: Int
)


// 3 layer arch
//     Mapper(DTO === Entity)
// UI --> C --> S --> R --> DB
//      (DTO)  (DTO)

// DDD + Hexagonal Arch
