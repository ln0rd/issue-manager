package com.leo.entity

import com.leo.enum.VoteEnum
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "vote")
data class VoteEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val issueId: Long,
    val sessionId: Long,
    val userId: Long,
    val vote: VoteEnum
)
