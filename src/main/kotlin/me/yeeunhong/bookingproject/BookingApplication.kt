package me.yeeunhong.bookingproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class BookingApplication
fun main(args: Array<String>) {
    runApplication<BookingApplication> (*args)
}