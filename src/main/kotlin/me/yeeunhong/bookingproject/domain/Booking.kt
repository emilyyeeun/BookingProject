package me.yeeunhong.bookingproject.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name ="bookings")
data class Booking (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false, updatable = false)
    var id: Long = 1,

    @ManyToOne
    @Column(name="store_id")
    var storeId: Long,

    @ManyToOne
    @Column(name = "user_id", nullable = false)
    var userId: Long,

    @CreatedDate
    @Column
    var createdAt: LocalDateTime
)