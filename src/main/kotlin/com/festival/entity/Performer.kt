package org.example.com.festival.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "performer")
class Performer: PanacheEntity() {

    @field:NotBlank
    lateinit var name: String

    @Enumerated(EnumType.STRING)
    lateinit var genre: Genre

    lateinit var about: String

    @ManyToMany(fetch = FetchType.LAZY)
    var festivals: MutableList<Festival> = mutableListOf()

    @ManyToOne
    @JoinColumn(name = "created_by_id") // fk in venue table this will be use to perform join query // TODO We'll understand it later
    var createdBy: UserAccount? = null
}

// Hibernates (ORM) ===> Java Object/ Kotlin Object ===> Convert to SQL query ==> Execute in DB
// Read data from SQL ===> Convert it to Java Object/ Kotlin Object

// Java/Kotlin ===> Hibernates ==> SQL/DB Connect, Read ==> Repository Layer (DAO)