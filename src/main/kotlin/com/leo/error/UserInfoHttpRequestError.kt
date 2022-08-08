package com.leo.error

import java.lang.Exception

class UserInfoHttpRequestError : Exception(message) {
    companion object {
        const val message: String = "CPF not valid"
    }
}
