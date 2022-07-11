package ru.icebitsy.ice_vidget_back.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.icebitsy.ice_vidget_back.dto.QrDataRequest
import ru.icebitsy.ice_vidget_back.dto.QrResponse

@RestController
@RequestMapping("qr-api/v1/qr")
interface QrControllerApi {

@PostMapping
fun getQrString(@RequestBody qrDataRequest: QrDataRequest): ResponseEntity<QrResponse>

}