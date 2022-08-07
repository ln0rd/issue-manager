package com.leo.converter

import com.leo.entity.SessionEntity
import com.leo.model.CreateSessionRequest
import com.leo.model.CreateSessionResponse
import com.leo.model.Session
import jakarta.inject.Singleton

@Singleton
class SessionConverter {

    fun fromCreateRequest(createSessionRequest: CreateSessionRequest): Session {
        return Session(
            issueId = createSessionRequest.issueId,
            startAt = createSessionRequest.startAt,
            endAt = createSessionRequest.endAt
        )
    }

    fun toEntity(session: Session): SessionEntity {
        return SessionEntity(
            issueId = session.issueId,
            startAt = session.startAt,
            endAt = session.endAt
        )
    }

    fun fromEntity(sessionEntity: SessionEntity): Session {
        return Session(
            id = sessionEntity.id,
            issueId = sessionEntity.issueId,
            startAt = sessionEntity.startAt,
            endAt = sessionEntity.endAt
        )
    }

    fun toCreateResponse(session: SessionEntity): CreateSessionResponse {
        return CreateSessionResponse(
            id = session.id,
            issueId = session.issueId
        )
    }
}
