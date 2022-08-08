package com.leo.useCase

import com.leo.client.UserInfoClient
import com.leo.converter.SessionConverter
import com.leo.converter.VoteConverter
import com.leo.entity.SessionEntity
import com.leo.entity.VoteEntity
import com.leo.error.ClosedSessionException
import com.leo.error.CpfNotValidError
import com.leo.error.DatabaseComunicationException
import com.leo.error.UserInfoCommunicateError
import com.leo.error.UserInfoHttpRequestError
import com.leo.error.VoteAlreadyExistException
import com.leo.logger.Log
import com.leo.model.Session
import com.leo.model.UserInfoResponse
import com.leo.model.Vote
import com.leo.model.VoteRequest
import com.leo.repository.SessionRepository
import com.leo.repository.VoteRepository
import jakarta.inject.Singleton
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

@Singleton
class CreateVoteUseCase(
    private val voteRepository: VoteRepository,
    private val sessionRepository: SessionRepository,
    private val sessionConverter: SessionConverter,
    private val voteConverter: VoteConverter,
    private val log: Log,
    private val userInfoClient: UserInfoClient
) {

    fun createVote(voteRequest: VoteRequest): Vote {
        val voteDomain: Vote = voteConverter.fromRequest(voteRequest)

        val userInfoResponse: UserInfoResponse?
        try {
            userInfoResponse = userInfoClient.validateCpf(voteDomain.cpf)
        } catch (e: Exception) {
            throw UserInfoCommunicateError()
        }

        if (userInfoResponse == null) {
            throw UserInfoHttpRequestError()
        }

        validateUserInfoStatus(userInfoResponse.status)

        val votesEntityList: List<VoteEntity> =
            voteRepository.findByIssueAndUserId(voteDomain.issueId, voteDomain.userId)

        if (votesEntityList.isNotEmpty()) {
            log.warn("Vote already exist for this issue and user")
            throw VoteAlreadyExistException()
        }

        if (!isSessionInValidRangeOfDateTime(voteDomain.sessionId)) {
            log.warn("This session is closed")
            throw ClosedSessionException()
        }

        val voteCreated: VoteEntity = voteRepository.save(voteConverter.toEntity(voteDomain))
        return voteConverter.fromEntity(voteCreated)
    }

    private fun isSessionInValidRangeOfDateTime(sessionId: Long): Boolean {
        lateinit var sessionEntity: SessionEntity
        val id: Long = sessionId
        try {
            sessionEntity = sessionRepository.findById(id).get()
        } catch (e: Exception) {
            throw DatabaseComunicationException()
        }

        val sessionDomain: Session = sessionConverter.fromEntity(sessionEntity)
        println(sessionDomain)

        val dateTimeNow: LocalDateTime = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"))
        val startDiffInSeconds = ChronoUnit.SECONDS.between(sessionDomain.startAt, dateTimeNow)
        val endDiffInSeconds = ChronoUnit.SECONDS.between(sessionDomain.endAt, dateTimeNow)

        if (startDiffInSeconds > 0 && endDiffInSeconds < 0) {
            return true
        }

        return false
    }

    private fun validateUserInfoStatus(status: String) {
        if (status != "ABLE_TO_VOTE") {
            throw CpfNotValidError()
        }
    }
}
