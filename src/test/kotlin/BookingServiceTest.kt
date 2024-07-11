package me.yeeunhong.bookingproject

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import me.yeeunhong.bookingproject.domain.Booking
import me.yeeunhong.bookingproject.repository.BookingRepository
import me.yeeunhong.bookingproject.service.BookingService

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDateTime

@ExtendWith(MockKExtension::class)
internal class BookingServiceTest {

    @MockK
    lateinit var bookingRepository: BookingRepository

    @InjectMockKs
    lateinit var bookingService: BookingService

    @Test
    @DisplayName("예약을 만든다")
    fun `test create booking`() {
        val now = LocalDateTime.now()
        //given
        val booking = Booking(
            storeId = 1,
            userId = 1,
            createdAt = now
        )

        //when
        every { bookingRepository.save(any()) } returns booking


        //do
        val createdBooking = bookingService.createBooking(1, 1)

        assertEquals(booking, createdBooking)
    }


}