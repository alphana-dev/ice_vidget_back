package ru.icebitsy.ice_vidget_back.backClient

import feign.HeaderMap
import feign.Headers
import feign.Param
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import ru.icebitsy.ice_vidget_back.dto.*

@FeignClient(value = "qr-back-v1", url = "\${qr.back.url}")
interface BackClient {

    /**Логинимся на бек приложения с кодом магазина*/
    @PostMapping(value = ["/auth/login/shop"], produces = ["application/json"], consumes = ["application/json"])
    fun loginToBack(@RequestBody loginShopCodeRequest: LoginShopCodeRequest): ResponseEntity<UserDto>


    @PostMapping(value = ["shops/qrc"], produces = ["application/json"], consumes = ["application/json"])
    fun registerQrc(
        @RequestBody shopQrcRegisterRequest: ShopQrcRegisterRequest,
        @RequestHeader headers: Map<String, String>
    ): ResponseEntity<DataResponse<Int, QrcDto>>

}