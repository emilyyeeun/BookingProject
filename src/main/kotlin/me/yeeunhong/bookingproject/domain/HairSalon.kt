package me.yeeunhong.bookingproject.domain

import jakarta.persistence.*
import me.yeeunhong.bookingproject.type.StoreType

@Entity
@Table(name ="hairsalons")
data class HairSalon (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    var id: Long = 1,

    @Column(name = "name", unique = false, nullable = false)
    var name: String
)