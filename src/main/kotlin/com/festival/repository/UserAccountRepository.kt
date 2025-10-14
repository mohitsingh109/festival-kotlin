package org.example.com.festival.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import org.example.com.festival.entity.UserAccount

@ApplicationScoped // JPA Annotation It's telling to create object of UserAccountRepository
class UserAccountRepository : PanacheRepository<UserAccount> {
    fun findByUsername(username: String): UserAccount? = find("username", username).firstResult()
}

// JPA (save, find by pk, delete by pk)  ==> Hibernates (ORM)
//findByUsername("abc")