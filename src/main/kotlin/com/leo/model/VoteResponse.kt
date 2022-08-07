package com.leo.model

import com.leo.enum.VoteEnum

data class VoteResponse(
    val id: Long?,
    val issueId: Long,
    val sessionId: Long,
    val userId: Long,
    val vote: VoteEnum
)
