package org.example.com.festival.service

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.example.com.festival.dto.PerformerRequestDto
import org.example.com.festival.entity.Performer
import org.example.com.festival.repository.PerformerRepository
import org.example.com.festival.webapi.mapper.PerformerMapper

@ApplicationScoped
class PerformerService(private val performerRepository: PerformerRepository,
                       private val performerMapper: PerformerMapper) {

    //TODO : Consider userId
    //TODO : create responseDto : hint (maybe need to do something for enum datatype)
    // look at the expression concept of mapstrut
    @Transactional
    fun create(performerRequestDto: PerformerRequestDto) : Performer {
        val performer = performerMapper.toEntity(performerRequestDto)
        performerRepository.persist(performer)
        return performer
    }
}