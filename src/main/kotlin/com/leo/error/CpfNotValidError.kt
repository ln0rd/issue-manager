package com.leo.error

import java.lang.Exception

class CpfNotValidError : Exception(message) {
    companion object {
        const val message: String = "Invalid CPF"
    }
}
