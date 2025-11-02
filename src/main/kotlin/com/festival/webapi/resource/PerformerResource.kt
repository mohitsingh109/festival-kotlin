package org.example.com.festival.webapi.resource

import jakarta.validation.Valid
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.example.com.festival.dto.PerformerRequestDto
import org.example.com.festival.service.PerformerService

@Path("/api/performer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class PerformerResource(private val  performerService: PerformerService) {

    @POST
    fun create(@Valid dto: PerformerRequestDto): Response {
        val performer = performerService.create(dto)
        return Response.status(Response.Status.CREATED)
            .entity(performer)
            .build()
    }

}