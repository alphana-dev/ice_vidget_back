package ru.icebitsy.ice_vidget_back.dto

data class ShopQrcRegisterRequest(
    val shopUid: String,
    val amount: Long,      //	number[12]	Сумма в копейках. Целое, положительное число. Максимум 12 знаков.
    val currency: String? = "RUB", //string[3]	Валюта операции: RUB. Обязательно, если заполнена сумма.
    val paymentPurpose: String? = null, //	string[140]	Дополнительная информация от ТСП.
    val qrTtl: Long? = null, //number	Минимальное значение срока использования динамической платежной ссылки в целых минутах. Необязательное. Cм. Операционный бюллетень СБП 03.2021_2021.02.11.
    val redirectUrl: String? = null //string[1024]	URL для автоматического возврата Плательщика из приложения Банка в приложение или на сайт ТСП. Необязательное, ASCII, либо percent-encoded octets согласно RFC3986. См. Операционный бюллетень СБП 18.2021_2021.09.06.
)