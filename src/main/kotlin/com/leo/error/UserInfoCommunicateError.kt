package com.leo.error

import java.lang.Exception

class UserInfoCommunicateError : Exception(message) {
    companion object {
        const val message: String = "We have a problem to send request by userInfo client"
    }
}
