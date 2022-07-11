package ru.icebitsy.ice_vidget_back.service

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.icebitsy.ice_vidget_back.backClient.BackClient
import ru.icebitsy.ice_vidget_back.dto.*

@Service
class BackRelationService(
    private val backClient: BackClient
) {

    fun loginToBack(shopAuthCode: String): ResponseEntity<UserDto>? {
        return backClient.loginToBack(LoginShopCodeRequest(shopAuthCode))
    }

    fun getQrc(shopQrcRegisterRequest: ShopQrcRegisterRequest, headers: Map<String, String>): ResponseEntity<DataResponse<Int, QrcDto>> {
        return backClient.registerQrc(shopQrcRegisterRequest, headers)
    }
}