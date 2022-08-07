package com.leo.model

import com.leo.enum.ResultEnum

data class ResultSession(
    val sessionId: Long,
    val positiveVotes: Int,
    val negativeVotes: Int,
    val result: ResultEnum
)
