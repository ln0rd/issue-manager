package com.leo.useCase

import com.leo.converter.IssueConverter
import com.leo.entity.IssueEntity
import com.leo.model.CreateIssueRequest
import com.leo.model.CreateIssueResponse
import com.leo.model.Issue
import com.leo.repository.IssueRepository
import jakarta.inject.Singleton

@Singleton
class CreateIssueUseCase(
    private val issueRepository: IssueRepository,
    private val issueConverter: IssueConverter
) {

    fun create(createIssueRequest: CreateIssueRequest): CreateIssueResponse {
        val issueDomain: Issue = issueConverter.fromCreateRequest(createIssueRequest)
        val createdIssue: IssueEntity = issueRepository.save(issueConverter.toEntity(issueDomain))
        return issueConverter.toCreateResponse(createdIssue)
    }
}
