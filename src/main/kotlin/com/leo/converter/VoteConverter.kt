package com.leo.converter

import com.leo.entity.VoteEntity
import com.leo.model.Vote
import com.leo.model.VoteRequest
import com.leo.model.VoteResponse
import jakarta.inject.Singleton

@Singleton
class VoteConverter {

    fun fromRequest(voteRequest: VoteRequest): Vote {
        return Vote(
            issueId = voteRequest.issueId,
            sessionId = voteRequest.sessionId,
            userId = voteRequest.userId,
            vote = voteRequest.vote
        )
    }

    fun toEntity(vote: Vote): VoteEntity {
        return VoteEntity(
            issueId = vote.issueId,
            sessionId = vote.sessionId,
            userId = vote.userId,
            vote = vote.vote
        )
    }

    fun fromEntity(voteEntity: VoteEntity): Vote {
        return Vote(
            id = voteEntity.id,
            issueId = voteEntity.issueId,
            sessionId = voteEntity.sessionId,
            userId = voteEntity.userId,
            vote = voteEntity.vote
        )
    }

    fun toResponse(voteEntity: Vote): VoteResponse {
        return VoteResponse(
            id = voteEntity.id,
            issueId = voteEntity.issueId,
            sessionId = voteEntity.sessionId,
            userId = voteEntity.userId,
            vote = voteEntity.vote
        )
    }
}
