package org.example.com.festival.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "venue")
class Venue: PanacheEntity(){

    @field:NotBlank(message = "Name is required")
    @field:Size(min = 2, max = 255)
    @Column(nullable = false)
    lateinit var name: String

    @field:NotBlank(message = "Location is required")
    @Column(nullable = false)
    lateinit var location: String

    @field: NotNull
    @field:Min(1)
    @Column(nullable = false)
    var capacity: Int = 1

//    @ManyToOne // Many Venue can be created by one user
//    @JoinColumn(name = "created_by_id") // fk in venue table this will be use to perform join query // TODO We'll understand it later
//    var createdBy: UserAccount? = null
}