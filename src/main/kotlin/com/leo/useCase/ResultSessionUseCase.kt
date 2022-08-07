package com.leo.useCase

import com.leo.enum.ResultEnum
import com.leo.model.ResultSession
import com.leo.repository.VoteRepository
import jakarta.inject.Singleton

@Singleton
class ResultSessionUseCase(
    private val voteRepository: VoteRepository
) {

    fun getResult(id: Long): ResultSession {
        val positiveVotes: Int = voteRepository.countPositivesVotesBySessionId(id)
        val negativeVotes: Int = voteRepository.countNegativeVotesBySessionId(id)

        if (negativeVotes == 0 && positiveVotes == 0) {
            return ResultSession(
                sessionId = id,
                positiveVotes = positiveVotes,
                negativeVotes = negativeVotes,
                result = ResultEnum.NOT_EXIST
            )
        }

        if (negativeVotes > positiveVotes || negativeVotes == positiveVotes) {
            return ResultSession(
                sessionId = id,
                positiveVotes = positiveVotes,
                negativeVotes = negativeVotes,
                result = ResultEnum.REFUSED
            )
        }

        return ResultSession(
            sessionId = id,
            positiveVotes = positiveVotes,
            negativeVotes = negativeVotes,
            result = ResultEnum.APPROVED
        )
    }
}
