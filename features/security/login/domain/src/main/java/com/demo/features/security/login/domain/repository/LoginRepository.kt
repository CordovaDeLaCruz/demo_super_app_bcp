package com.demo.features.security.login.domain.repository

import com.demo.features.security.login.domain.model.LoginRequestModel
import com.demo.features.security.login.domain.model.LoginResponseModel

fun interface LoginRepository {
    suspend fun login(loginRequestModel: LoginRequestModel): Result<LoginResponseModel>
}