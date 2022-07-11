package ru.icebitsy.ice_vidget_back.dto


data class QrDataRequest(
    val shopAuthCode: String?,
    val shopUid: String?,
    val amount: Double,
    val order: String? = null,
    val description: String? = null,
    val name: String? = null,
    val email: String? = null,
    val phone: String? = null,
    val currency: String? = null
)
