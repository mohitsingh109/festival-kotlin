package org.example.com.festival.webapi.resource

import jakarta.ws.rs.Consumes
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.example.com.festival.service.VenueService
import org.example.com.festival.webapi.mapper.VenueMapper

@Path("/api/venues")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class VenueResource(
    private val service: VenueService,
    private val mapper: VenueMapper
) {


}