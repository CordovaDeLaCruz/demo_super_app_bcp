package com.demo.features.security.login.data.di

import com.demo.features.security.login.data.api.LoginApi
import com.demo.features.security.login.data.mapper.toDTO
import com.demo.features.security.login.domain.model.LoginRequestModel
import com.demo.features.security.login.domain.model.LoginResponseModel
import retrofit2.HttpException
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginService @Inject constructor(private val retrofit: Retrofit) {

    suspend fun login(loginRequestModel: LoginRequestModel): Result<LoginResponseModel>{
        return try {
            val responseService = retrofit.create(LoginApi::class.java)
                .loginService(loginRequestModel.toDTO())
            if(responseService.isSuccessful){
                val response = LoginResponseModel(token = responseService.body()?.token)
                Result.success(response)
            }else{
                Result.failure(HttpException(responseService))
            }
        }catch (e: Exception){
            Result.failure(Error(e))
        }
    }
}