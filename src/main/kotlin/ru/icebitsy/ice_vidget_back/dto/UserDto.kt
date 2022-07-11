package ru.icebitsy.ice_vidget_back.dto

data class UserDto(
    val id: Long,
    val login: String,
    val userName: String,
    val phone: String,
    var roles: ArrayList<String> = ArrayList(),
    val isActive: Boolean
)