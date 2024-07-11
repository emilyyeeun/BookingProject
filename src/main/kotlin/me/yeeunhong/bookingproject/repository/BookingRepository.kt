package me.yeeunhong.bookingproject.repository

import me.yeeunhong.bookingproject.domain.Booking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookingRepository : JpaRepository<Booking, Long> {
    fun getAllBookings(): List<Booking>
    fun findBookingById(id: Long): Booking
    fun findBookingsByStoreId(storeId: Long): List<Booking>
    fun findBookingsByUserId(userId: Long): List<Booking>
}