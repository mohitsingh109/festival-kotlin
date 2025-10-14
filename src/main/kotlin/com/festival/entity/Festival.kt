package org.example.com.festival.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.*

@Entity
@Table(name = "festival")
class Festival: PanacheEntity() { // Full Fetch

    lateinit var name: String

    lateinit var theme: String

    var description: String? = null

    @ManyToMany(fetch = FetchType.LAZY) // Many To Many (Bridge table)
    @JoinTable(
        name = "festival_performer",
        joinColumns = [JoinColumn(name="festival_id")],
        inverseJoinColumns = [JoinColumn(name="performer_id")]
    )
    val performers: MutableList<Performer> = mutableListOf()

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id", nullable = false) // fk in festival table
    lateinit var venue: Venue
}