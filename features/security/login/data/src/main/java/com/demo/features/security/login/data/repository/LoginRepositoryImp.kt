package com.demo.features.security.login.data.repository

import com.demo.features.security.login.data.api.LoginApi
import com.demo.features.security.login.data.mapper.toDomain
import com.demo.features.security.login.data.model.LoginRequestDto
import com.demo.features.security.login.data.model.LoginResponseDto
import com.demo.features.security.login.domain.model.LoginRequestModel
import com.demo.features.security.login.domain.model.LoginResponseModel
import com.demo.features.security.login.domain.repository.LoginRepository
import com.google.gson.Gson
import retrofit2.HttpException
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(
    private val loginApi: LoginApi,
    private val gson: Gson
) : LoginRepository{
    override suspend fun login(loginRequestModel: LoginRequestModel): Result<LoginResponseModel> {
        return try{
            val loginRequestDto = LoginRequestDto(
                email = loginRequestModel.email,
                password = loginRequestModel.password
            )
            val result = loginApi.loginService(loginRequestDto)
            if (result.isSuccessful) {
                val json = gson.toJson(result.body())
                val loginResponseDto: LoginResponseDto =
                    gson.fromJson(json, LoginResponseDto::class.java)
                val loginResponse = loginResponseDto.toDomain()
                Result.success(loginResponse)
            } else {
                Result.failure(HttpException(result))
            }
        }catch (t: Throwable){
            Result.failure(t)
        }
    }

}