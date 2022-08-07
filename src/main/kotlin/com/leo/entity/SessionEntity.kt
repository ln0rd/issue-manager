package com.leo.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "session")
data class SessionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val issueId: Long,
    val startAt: LocalDateTime?,
    val endAt: LocalDateTime?
)
