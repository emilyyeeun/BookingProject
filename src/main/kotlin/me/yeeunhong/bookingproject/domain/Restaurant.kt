package me.yeeunhong.bookingproject.domain

import jakarta.persistence.*

@Entity
@Table(name ="restaurants")
data class Restaurant (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    var id: Long = 1,

    @Column(name = "name", unique = false, nullable = false)
    var name: String
)