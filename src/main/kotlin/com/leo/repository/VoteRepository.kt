package com.leo.repository

import com.leo.entity.VoteEntity
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface VoteRepository : JpaRepository<VoteEntity, Long> {

    @Query("FROM vote WHERE vote.issueId = :issueId and vote.userId = :userId")
    fun findByIssueAndUserId(issueId: Long, userId: Long): List<VoteEntity>

    @Query("SELECT COUNT(*) FROM vote v WHERE v.session_id = :id AND v.vote = 0", nativeQuery = true)
    fun countPositivesVotesBySessionId(id: Long): Int

    @Query("SELECT COUNT(*) FROM vote v WHERE v.session_id = :id AND v.vote = 1", nativeQuery = true)
    fun countNegativeVotesBySessionId(id: Long): Int
}
