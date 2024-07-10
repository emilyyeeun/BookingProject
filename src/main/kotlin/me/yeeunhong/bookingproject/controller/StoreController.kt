package me.yeeunhong.bookingproject.controller

import StoreRequest
import me.yeeunhong.bookingproject.domain.Store
import me.yeeunhong.bookingproject.service.StoreService
import org.springframework.web.bind.annotation.*
import me.yeeunhong.bookingproject.type.StoreType

@RestController
@RequestMapping("/store")
class StoreController(
    private val storeService: StoreService
) {
    @GetMapping
    fun getStores() : List<Store> {
        return storeService.getAllStores()
    }

    @PostMapping
    fun createStore(@RequestBody storeRequest: StoreRequest): Store {
        val storeType = when (storeRequest.storeTypeInput) {
            "Restaurant" -> StoreType.RESTAURANT
            "Hairsalon" -> StoreType.HAIRSALON
            "Accomodation" -> StoreType.ACCOMODATION
            else -> null
        }

        return storeService.createStore(storeType!!, storeRequest.storeName)
    }

    @GetMapping("/{storeId}")
    fun getStore(@PathVariable("storeId") storeId:Long) : Store {
        return storeService.getStore(storeId);
    }

    @PatchMapping("/{storeId}/storeName")
    fun updateStoreName(
        @PathVariable("storeId") storeId: Long,
        @RequestBody storeName: String) : Store {
        return storeService.updateStoreName(storeId, storeName)
    }

}