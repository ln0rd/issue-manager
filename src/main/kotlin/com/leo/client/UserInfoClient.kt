package com.leo.client

import com.leo.model.UserInfoResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("https://user-info.herokuapp.com")
interface UserInfoClient {

    @Get("/users/{cpf}")
    fun validateCpf(cpf: String): UserInfoResponse?
}
