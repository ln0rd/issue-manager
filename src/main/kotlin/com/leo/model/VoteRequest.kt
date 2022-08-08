package com.leo.model

import com.leo.enum.VoteEnum

data class VoteRequest(
    val issueId: Long,
    val sessionId: Long,
    val userId: Long,
    val vote: VoteEnum,
    val cpf: String
)
