package com.leo.controller

import com.leo.model.CreateIssueRequest
import com.leo.model.CreateIssueResponse
import com.leo.useCase.CreateIssueUseCase
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/issues/v1")
class IssueController(
    private val createIssueUseCase: CreateIssueUseCase
) {

    @Post()
    fun createIssue(@Body createIssueRequest: CreateIssueRequest): HttpResponse<CreateIssueResponse> {
        return HttpResponse.created(createIssueUseCase.create(createIssueRequest))
    }
}
