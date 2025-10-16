package org.example.com.festival.service

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.example.com.festival.entity.Venue
import org.example.com.festival.repository.VenueRepository

@ApplicationScoped
class VenueService(private val venueRepository: VenueRepository) {

    // List all venue
    fun listAll(): List<Venue> = venueRepository.listAll()

    // find a venue
    fun findVenueById(id: Long): Venue {
        return venueRepository.findById(id) ?: throw  NoSuchElementException("Venue $id not found")
    }

    // create venue
    @Transactional
    fun create(v: Venue): Venue {
        venueRepository.persist(v)
        return v
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