package org.example.com.festival.webapi.resource

import jakarta.validation.Valid
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.example.com.festival.dto.UserAccountRegistrationDto
import org.example.com.festival.service.UserAccountService

@Path("/api/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class UserResource (
    private val userAccountService: UserAccountService
) {

    @POST
    @Path("/register")
    fun register(@Valid dto: UserAccountRegistrationDto): Response {
        val user = userAccountService.register(dto.username!!, dto.password!!)
        return Response.status(Response.Status.CREATED)
            .entity(mapOf("id" to user.id, "username" to user.username))
            .build()

        /***
         * { "id": "123", "username": "abc" }
         */

        // Login Code
        // Post
        // DTO request payload: LoginRequestDto
        // DTO response payload: LoginResponseDto
        // 200
    }
}