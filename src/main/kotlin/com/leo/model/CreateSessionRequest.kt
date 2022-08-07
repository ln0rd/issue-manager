package com.leo.model

import java.time.LocalDateTime

data class CreateSessionRequest(
    val issueId: Long,
    val startAt: LocalDateTime? = null,
    val endAt: LocalDateTime? = null
)
