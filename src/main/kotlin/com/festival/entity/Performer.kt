package org.example.com.festival.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "performer")
class Performer: PanacheEntity() {



}