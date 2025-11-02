package org.example.com.festival.webapi.mapper

import org.example.com.festival.dto.PerformerRequestDto
import org.example.com.festival.dto.PerformerResponseDto
import org.example.com.festival.entity.Genre
import org.example.com.festival.entity.Performer
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface PerformerMapper {
    fun toEntity(dto: PerformerRequestDto): Performer

//    fun toDto(performer: Performer): PerformerRequestDto

//    @Mapping(
//        target="genre",
//        expression = "java(Genre.valueOf(performer.getType().toUpperCase()))"
//    )
//    fun toResposeDto(performer: Performer) : PerformerResponseDto
}