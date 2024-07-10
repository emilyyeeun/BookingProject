package me.yeeunhong.bookingproject.domain

import me.yeeunhong.bookingproject.type.StoreType
import jakarta.persistence.*

@Entity
@Table(name ="stores")
data class Store (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    var id: Long = 0,

    @Column(name = "storeType", unique = true, nullable = false)
    var storeType: StoreType = StoreType.RESTAURANT,

    @Column(name = "storeName", nullable = false)
    var storeName: String = ""
)