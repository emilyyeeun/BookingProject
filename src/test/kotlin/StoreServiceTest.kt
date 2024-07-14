package me.yeeunhong.bookingproject

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import me.yeeunhong.bookingproject.domain.Store
import me.yeeunhong.bookingproject.repository.StoreRepository
import me.yeeunhong.bookingproject.service.StoreService
import me.yeeunhong.bookingproject.type.StoreType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
internal class StoreServiceTest {

    @MockK
    lateinit var storeRepository: StoreRepository

    @InjectMockKs
    lateinit var storeService: StoreService

    @Test
    @DisplayName("스토어를 개설한다")
    fun `test create store`() {
        //given
        val store = Store(
            id = 1L,
            storeType = StoreType.RESTAURANT,
            storeName = "예니의 식당"
        )

        //when
        every { storeRepository.save(store) } returns store

        //do
        val createdStore = storeService.createStore(StoreType.RESTAURANT, "예니의 식당")

        assertEquals(store, createdStore)
    }

    @Test
    fun `test update store name`(){
        //given
        val value = "예니의 스토어"
        val store = Store(
            id = 1L,
            storeType = StoreType.RESTAURANT,
            storeName = "예니의 식당"
        )

        //when
        every {
            (storeRepository.findById(store.id))
        } returns Optional.of(store)
        every {
            storeRepository.save(store)
        } returns store

        //do
        val updatedStore = storeService.updateStoreName(store.id, value)

        //then
        assertEquals(store, updatedStore)
    }
}
