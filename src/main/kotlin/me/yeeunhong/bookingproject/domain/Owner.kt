package me.yeeunhong.bookingproject.domain

import jakarta.persistence.*

@Entity
@Table(name ="owners")
data class Owner (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    var id: Long = 1
)