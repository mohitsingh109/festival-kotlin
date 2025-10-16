package org.example.com.festival.webapi.mapper

import org.example.com.festival.dto.VenueRequestDto
import org.example.com.festival.dto.VenueResponseDto
import org.example.com.festival.entity.Venue
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface VenueMapper {
    fun toEntity(dto: VenueRequestDto): Venue

    //@Mapping(source = "id", target = "vId")
    fun toDto(venue: Venue): VenueResponseDto
}

// 4 ===> 10