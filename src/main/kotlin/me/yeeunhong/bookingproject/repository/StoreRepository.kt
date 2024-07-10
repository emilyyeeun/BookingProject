package me.yeeunhong.bookingproject.repository

import me.yeeunhong.bookingproject.domain.Store
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository : JpaRepository<Store, Long> {
    fun findByStoreName(name: String): List<Store>
}