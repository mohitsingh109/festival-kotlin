package org.example.com.festival.service

import at.favre.lib.crypto.bcrypt.BCrypt
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.example.com.festival.entity.UserAccount
import org.example.com.festival.repository.UserAccountRepository

@ApplicationScoped
class UserAccountService(
    private val userAccountRepository: UserAccountRepository
)  {

    fun findByIdOrThrow(id: Long): UserAccount {
        return userAccountRepository.findById(id) ?:
        throw NoSuchElementException("User $id not found")
    }

    fun findByUsername(username: String): UserAccount? = userAccountRepository.findByUsername(username)

    @Transactional
    fun register(username: String, rawPassword: String): UserAccount {
        require(username.isNotBlank()) { "Username is required" }
        require(rawPassword.isNotBlank()) { "Password is required" }

        if (findByUsername(username) != null) {
            throw IllegalArgumentException("Username already taken")
        }

        // We'll do the hash of the password here
        val hashed = BCrypt.withDefaults().hashToString(12, rawPassword.toCharArray())

        val user = UserAccount().apply {
            this.username = username
            this.password = hashed
            this.role = "ROLE_USER"
        }

        userAccountRepository.persist(user)
        return user
    }

    fun verifyPassword(username: String, rawPassword: String): Boolean {
        val user = findByUsername(username) ?: return false
        val result = BCrypt.verifyer().verify(rawPassword.toCharArray(), user.password)
        return result.verified
    }
}