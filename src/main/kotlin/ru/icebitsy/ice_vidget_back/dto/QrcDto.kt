package ru.icebitsy.ice_vidget_back.dto

import java.time.LocalDateTime

data class QrcDto(
    val id: Long,
    //дата регистрации
    val createDate: LocalDateTime,
    //Банковский счет ЮЛ, ИП или самозанятого Поле обязательно для заполнения, если qrcType = "01" или qrcType = "02".
    val caccacc: String,
    //Сумма в копейках. Целое, положительное число. Максимум 12 знаков.
    val amount: Long? = null,
    //Валюта операции: RUB. Обязательно, если заполнена сумма.
    val currency: String? = "RUB",
    //Тип QR-кода: 01 - QR-Static (QR наклейка), 02 - QR-Dynamic (QR на кассе).
    val qrctype: String,
    //Дополнительная информация от ТСП.
    val paymentPurpose: String? = null,
    //Минимальное значение срока использования динамической платежной ссылки в целых минутах.
    val qrTtl: Long? = null,
    //URL для автоматического возврата Плательщика из приложения Банка в приложение или на сайт ТСП.
    val redirectUrl: String? = null,
    //Версия payload QR-кода: 01 - Версия 1.
    val templateVersion: String = "01",
    /** Результат регистрации QR в СБП */
    //Идентификатор Платежной ссылки СБП.
    val regQrcId: String? = null,
    //Payload зарегистрированного QR-кода в СБП.
    val regPayload: String? = null,
    //image.content для картинки
    val imageContent: String? = null,
    var status: String,
    var statusDate: LocalDateTime,
    val merchantRef: Long,
    val terminalRef: Long,
    var createUserRef: Long,
    val code: String?,
    val message: String?
)