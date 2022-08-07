package com.leo.useCase

import com.leo.converter.SessionConverter
import com.leo.entity.SessionEntity
import com.leo.model.CreateSessionRequest
import com.leo.model.CreateSessionResponse
import com.leo.model.Session
import com.leo.repository.SessionRepository
import jakarta.inject.Singleton
import java.time.LocalDateTime
import java.time.ZoneId

@Singleton
class CreateSessionUseCase(
    private val sessionRepository: SessionRepository,
    private val sessionConverter: SessionConverter
) {

    fun create(createSessionRequest: CreateSessionRequest): CreateSessionResponse {
        val sessionDomain: Session = sessionConverter.fromCreateRequest(createSessionRequest)

        if (sessionDomain.startAt == null) {
            sessionDomain.startAt = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"))
        }

        if (sessionDomain.endAt == null) {
            sessionDomain.endAt = LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).plusMinutes(1)
        }

        val sessionCreated: SessionEntity = sessionRepository.save(sessionConverter.toEntity(sessionDomain))
        return sessionConverter.toCreateResponse(sessionCreated)
    }
}
