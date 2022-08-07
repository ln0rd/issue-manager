package com.leo.logger

import jakarta.inject.Singleton

@Singleton
class Log {
    fun debug(message: String?) {
        println(message)
    }

    fun info(message: String?) {
        println(message)
    }

    fun warn(message: String?) {
        println(message)
    }

    fun error(message: String?) {
        println(message)
    }
}
