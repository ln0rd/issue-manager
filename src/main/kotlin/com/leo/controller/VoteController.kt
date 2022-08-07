package com.leo.controller

import com.leo.converter.VoteConverter
import com.leo.model.VoteRequest
import com.leo.model.VoteResponse
import com.leo.useCase.CreateVoteUseCase
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/vote/v1")
class VoteController(
    private val createVoteUseCase: CreateVoteUseCase,
    private val voteConverter: VoteConverter
) {

    @Post
    fun createVote(@Body voteRequest: VoteRequest): HttpResponse<VoteResponse> {
        val voteResponse: VoteResponse = voteConverter.toResponse(createVoteUseCase.createVote(voteRequest))
        return HttpResponse.created(voteResponse)
    }
}
