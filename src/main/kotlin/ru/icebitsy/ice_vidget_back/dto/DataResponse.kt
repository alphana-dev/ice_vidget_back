package ru.icebitsy.ice_vidget_back.dto

data class DataResponse<K, T>(
    val code: K,
    val message: String,
    val data: T? = null
)
