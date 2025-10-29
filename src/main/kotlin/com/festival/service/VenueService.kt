package org.example.com.festival.service

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.example.com.festival.dto.VenueRequestDto
import org.example.com.festival.entity.Venue
import org.example.com.festival.repository.UserAccountRepository
import org.example.com.festival.repository.VenueRepository
import org.example.com.festival.webapi.mapper.VenueMapper

@ApplicationScoped
class VenueService(private val venueRepository: VenueRepository,
                   private val venueMapper: VenueMapper,
                   private val userAccountRepository: UserAccountRepository ) {

    // List all venue
    fun listAll(): List<Venue> = venueRepository.listAll()

    // find a venue
    fun findVenueById(id: Long): Venue {
        val venue = venueRepository.findById(id)
        return venue ?: throw  NoSuchElementException("Venue $id not found")
    }

    // create venue
    @Transactional
    fun create(venueRequestDto: VenueRequestDto): Venue {
        val venue = venueMapper.toEntity(venueRequestDto)
        venueRequestDto.userId?.let {
            val userAccount = userAccountRepository.findById(it)
            venue.createdBy = userAccount
        }
        venueRepository.persist(venue)
        return venue
    }

    // update venue
    @Transactional
    fun update(id: Long, update: Venue) {
        val existing = findVenueById(id)
        existing.name = update.name
        existing.location = update.location
        existing.capacity = update.capacity
        venueRepository.persist(existing)
    }

    // delete venue
    @Transactional
    fun delete(id: Long) {
        if(!venueRepository.deleteById(id))
            throw NoSuchElementException("Venue $id not found")
    }
}