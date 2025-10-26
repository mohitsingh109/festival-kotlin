package org.example.com.festival.webapi.resource

import jakarta.validation.Valid
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.example.com.festival.dto.VenueRequestDto
import org.example.com.festival.service.VenueService
import org.example.com.festival.webapi.mapper.VenueMapper

@Path("/api/venues")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class VenueResource(
    private val service: VenueService,
    private val mapper: VenueMapper
) {

    @GET
    fun getAllVenue() = service.listAll().map(mapper::toDto) // Long Format: .map { v ->  mapper.toDto(v)}
    //mapper::toDto Method reference

    @GET
    @Path("{id}")
    fun getVenueById(@PathParam("id") id: Long) = mapper.toDto(service.findVenueById(id))

    @POST
    fun create(@Valid dto: VenueRequestDto): Response {
        println("Received DTO: $dto")
        val entity = mapper.toEntity(dto)
        val saved = service.create(entity)
        return Response.status(Response.Status.CREATED)
            .entity(mapper.toDto(saved))
            .build()
    }

    @DELETE
    @Path("{id}")
    fun delete(@PathParam("id") id: Long): Response {
        service.delete(id);
        return Response.noContent().build()
    }

}