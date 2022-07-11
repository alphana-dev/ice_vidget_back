package ru.icebitsy.ice_vidget_back

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class IceVidgetBackApplication

fun main(args: Array<String>) {
    runApplication<IceVidgetBackApplication>(*args)
}
