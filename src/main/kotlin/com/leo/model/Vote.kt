package com.leo.model

import com.leo.enum.VoteEnum

data class Vote(
    val id: Long? = null,
    val issueId: Long,
    val sessionId: Long,
    val userId: Long,
    val vote: VoteEnum
)
