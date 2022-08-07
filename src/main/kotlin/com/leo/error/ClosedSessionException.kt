package com.leo.error

import jakarta.inject.Singleton
import java.lang.Exception

@Singleton
class ClosedSessionException : Exception(message) {
    companion object {
        const val message: String = "Session had been closed"
    }
}
