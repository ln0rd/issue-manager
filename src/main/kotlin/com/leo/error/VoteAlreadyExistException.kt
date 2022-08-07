package com.leo.error

import jakarta.inject.Singleton
import java.lang.Exception

@Singleton
class VoteAlreadyExistException : Exception(message) {
    companion object {
        const val message: String = "Vote already exist for this issue"
    }
}
