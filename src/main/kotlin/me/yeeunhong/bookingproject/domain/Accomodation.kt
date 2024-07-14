package me.yeeunhong.bookingproject.domain

import jakarta.persistence.*

@Entity
@Table(name ="accomodations")
data class Accomodation (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    var id: Long = 1,

    @Column(name = "name", unique = false, nullable = false)
    var name: String
)