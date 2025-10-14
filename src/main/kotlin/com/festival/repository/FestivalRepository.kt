package org.example.com.festival.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import org.example.com.festival.entity.Festival

@ApplicationScoped
class FestivalRepository : PanacheRepository<Festival>