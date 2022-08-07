package com.leo.model

import java.time.LocalDateTime

data class Session(
    val id: Long? = null,
    val issueId: Long,
    var startAt: LocalDateTime? = null,
    var endAt: LocalDateTime? = null
)
