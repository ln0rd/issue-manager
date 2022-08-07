package com.leo.controller

import com.leo.model.CreateSessionRequest
import com.leo.model.CreateSessionResponse
import com.leo.model.ResultSession
import com.leo.useCase.CreateSessionUseCase
import com.leo.useCase.ResultSessionUseCase
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

@Controller("/session/v1")
class SessionController(
    private val createSessionUseCase: CreateSessionUseCase,
    private val resultSessionUseCase: ResultSessionUseCase,
) {

    @Post
    fun createSession(@Body createSessionRequest: CreateSessionRequest): HttpResponse<CreateSessionResponse> {
        return HttpResponse.created(createSessionUseCase.create(createSessionRequest))
    }

    @Get("/{id}")
    fun getResultBySessionId(@PathVariable id: Long): HttpResponse<ResultSession> {
        return HttpResponse.ok(resultSessionUseCase.getResult(id))
    }
}
