package com.leo.error

import jakarta.inject.Singleton
import java.lang.Exception

@Singleton
class DatabaseComunicationException : Exception(message) {
    companion object {
        const val message: String = "We had some problem to communicate with our database"
    }
}
