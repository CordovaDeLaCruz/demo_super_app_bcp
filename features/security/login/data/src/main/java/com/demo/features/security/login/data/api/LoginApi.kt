package com.demo.features.security.login.data.api

import com.demo.features.security.login.data.model.LoginRequestDto
import com.demo.features.security.login.data.model.LoginResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("/api/login")
    suspend fun loginService(@Body request: LoginRequestDto): Response<LoginResponseDto>
}