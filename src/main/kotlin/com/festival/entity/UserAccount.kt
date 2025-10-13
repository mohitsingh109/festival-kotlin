package org.example.com.festival.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "user_account")
class UserAccount: PanacheEntity() {

    @Column(name = "username", nullable = false, unique = true)
    lateinit var username: String

    @Column(name = "password", nullable = false)
    lateinit var password: String

    @Column(nullable = false)
    var role: String = "ROLE_USER"
}