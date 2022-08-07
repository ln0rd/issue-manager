package com.leo.converter

import com.leo.entity.IssueEntity
import com.leo.model.CreateIssueRequest
import com.leo.model.CreateIssueResponse
import com.leo.model.Issue
import jakarta.inject.Singleton

@Singleton
class IssueConverter {

    fun fromCreateRequest(createIssueRequest: CreateIssueRequest): Issue {
        return Issue(
            title = createIssueRequest.title,
        )
    }

    fun toEntity(issue: Issue): IssueEntity {
        return IssueEntity(
            title = issue.title,
        )
    }

    fun fromEntity(issueEntity: IssueEntity): Issue {
        return Issue(
            id = issueEntity.id,
            title = issueEntity.title,
        )
    }

    fun toCreateResponse(issueEntity: IssueEntity): CreateIssueResponse {
        return CreateIssueResponse(
            id = issueEntity.id,
            title = issueEntity.title
        )
    }
}
