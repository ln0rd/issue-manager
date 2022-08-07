package com.leo.repository

import com.leo.entity.SessionEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface SessionRepository : JpaRepository<SessionEntity, Long>
