package com.leo.repository

import com.leo.entity.IssueEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface IssueRepository : JpaRepository<IssueEntity, Long>
