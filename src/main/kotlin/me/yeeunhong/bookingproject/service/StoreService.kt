package me.yeeunhong.bookingproject.service

import me.yeeunhong.bookingproject.domain.Store
import org.springframework.stereotype.Service
import me.yeeunhong.bookingproject.repository.StoreRepository
import me.yeeunhong.bookingproject.type.StoreType
import jakarta.transaction.Transactional


@Service
class StoreService(
    private var storeRepository: StoreRepository
) {

    @Transactional
    fun createStore(storeType: StoreType, storeName: String) : Store {
        val store = Store (
            storeType = storeType,
            storeName = storeName
        )
        return storeRepository.save(store)
    }

    fun getStore(storeId: Long) : Store {
        return storeRepository.findById(storeId).orElseThrow()
    }

    fun getAllStores() : List<Store> {
        return storeRepository.findAll()
    }

    @Transactional
    fun updateStoreName(storeId: Long, value: String) : Store {
        val store = storeRepository.findById(storeId).orElseThrow()
        store.storeName = value
        return storeRepository.save(store)
    }
}