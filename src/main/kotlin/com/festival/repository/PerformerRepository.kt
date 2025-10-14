package org.example.com.festival.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.example.com.festival.entity.Performer

class PerformerRepository : PanacheRepository<Performer>