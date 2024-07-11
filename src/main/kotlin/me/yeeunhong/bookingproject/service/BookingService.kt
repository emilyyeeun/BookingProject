package me.yeeunhong.bookingproject.service

import jakarta.transaction.Transactional
import me.yeeunhong.bookingproject.domain.Booking
import me.yeeunhong.bookingproject.repository.BookingRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class BookingService (
    private var bookingRepository : BookingRepository
) {
    fun getAllBookings(): List<Booking> {
        return bookingRepository.getAllBookings();
    }

    @Transactional
    fun createBooking(userId: Long, storeId: Long): Booking {
        val booking = Booking (
            storeId = storeId,
            userId = userId,
            createdAt = LocalDateTime.now()
        )
        return bookingRepository.save(booking)
    }

    fun getBookingById(bookingId: Long) : Booking {
        return bookingRepository.findBookingById(bookingId)
    }

    fun getBookingByUser(userId: Long) : List<Booking> {
        return bookingRepository.findBookingsByUserId(userId)
    }

    fun getBookingByStore(storeId: Long) : List<Booking> {
        return bookingRepository.findBookingsByStoreId(storeId)
    }
}