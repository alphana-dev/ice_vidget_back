package ru.icebitsy.ice_vidget_back.dto

data class QrResponse(
    val code: Int? = 0,
    val message: String? = null,
    val payload: String? = null,
    //Идентификатор Платежной ссылки СБП.
    val regQrcId: String? = null,

    )
