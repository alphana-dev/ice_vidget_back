package ru.icebitsy.ice_vidget_back.controller

import com.google.gson.Gson
import feign.FeignException
import org.apache.http.HttpException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import ru.icebitsy.ice_vidget_back.dto.*
import ru.icebitsy.ice_vidget_back.service.BackRelationService

@RestController
class QrControllerApiImpl(
    private val backRelationService: BackRelationService
) : QrControllerApi {

    /**Вернуть платежную ссылку*/
    override fun getQrString(qrDataRequest: QrDataRequest): ResponseEntity<QrResponse> {
        var code = 0
        var message = "Ошибка получения QR-кода"
        var user: UserDto? = null
        var access_token: String? = null
        var qrcDto: QrcDto? = null

        if (qrDataRequest.shopAuthCode != null) {
            try {
                /**В начале логинимся получаем access_token токен*/
                val response = backRelationService.loginToBack(qrDataRequest.shopAuthCode)
                if (response?.statusCode == HttpStatus.OK) {
                    if (response.headers.isNotEmpty()) {
                        if (response.headers["Set-Cookie"]!!.isNotEmpty()) {
                            for (header in response.headers["Set-Cookie"]!!) {
                                if (header.contains("access_token"))
                                    access_token = header.drop(13).takeWhile { it != ';' }
                            }
                        }
                    }
                    user = response?.body
                    /** Теперь получаем QR - код*/
                    if (qrDataRequest.shopUid != null) {
                        val qrResp = access_token?.let {
                            backRelationService.getQrc(
                                ShopQrcRegisterRequest(
                                    shopUid = qrDataRequest.shopUid,
                                    amount = (qrDataRequest.amount * 100).toLong(),
                                    currency = qrDataRequest.currency,
                                    paymentPurpose = qrDataRequest.description
                                ), mapOf("Cookie" to "access_token=$it","User-Agent" to "WebApp")
                            )
                        }
                       qrcDto = qrResp?.body?.data

                    } else {
                        code = 555
                        message = "Не указа уникальный код магазина"
                    }
                }
            } catch (e: FeignException) {
                var response = Gson().fromJson(e.contentUTF8(), DataResponse::class.java)
                if(response != null) {
                    code = response.code.toString().toDouble().toInt()
                    message = response.message
                } else{
                    code = e.hashCode()
                    message = e.message ?: "Неизвестная ошибка"
                }
            } catch (e: Exception) {
                code = 555
                message = e.message ?: "Неизвестная ошибка"
            }
        } else {
            var code = 555
            var message = "Не указан код авторизации магазина."
        }
        return if (code == 0)
            ResponseEntity.ok(QrResponse(payload = qrcDto?.regPayload))
        else
            ResponseEntity.ok(QrResponse(code = code, message = message))
    }
}