package com.leo.controller

import com.leo.error.ClosedSessionException
import com.leo.error.DatabaseComunicationException
import com.leo.error.VoteAlreadyExistException
import com.leo.model.ErrorResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error

@Controller
class GlobalErrorController {

    @Error(exception = ClosedSessionException::class, global = true)
    fun closedSessionException(): HttpResponse<ErrorResponse> {
        val response = HttpResponse.status<HttpStatus>(HttpStatus.CONFLICT)
        return response.body(ErrorResponse(statusCode = 409, message = ClosedSessionException.message))
    }

    @Error(exception = VoteAlreadyExistException::class, global = true)
    fun voteAlreadyExistException(): HttpResponse<ErrorResponse> {
        val response = HttpResponse.status<HttpStatus>(HttpStatus.CONFLICT)
        return response.body(ErrorResponse(statusCode = 409, message = ClosedSessionException.message))
    }

//    @Error(exception = DatabaseComunicationException::class, global = true)
//    fun databaseComunicationException(): HttpResponse<ErrorResponse> {
//        val response = HttpResponse.status<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR)
//        return response.body(ErrorResponse(statusCode = 500, message = DatabaseComunicationException.message))
//    }
//
//    @Error(exception = Exception::class, global = true)
//    fun genericException(): HttpResponse<ErrorResponse> {
//        val response = HttpResponse.status<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR)
//        return response.body(ErrorResponse(statusCode = 500, message = "something happened wrong"))
//    }
}
