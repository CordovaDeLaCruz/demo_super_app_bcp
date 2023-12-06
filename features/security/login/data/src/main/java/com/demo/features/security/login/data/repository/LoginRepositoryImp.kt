package com.demo.features.security.login.data.repository

import android.util.Log
import com.demo.features.security.login.data.di.LoginService
import com.demo.features.security.login.data.model.LoginResponseDto
import com.demo.features.security.login.domain.model.LoginRequestModel
import com.demo.features.security.login.domain.model.LoginResponseModel
import com.demo.features.security.login.domain.repository.LoginRepository
import com.google.gson.Gson
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(
    private val loginService: LoginService,
) : LoginRepository{
    private var gson = Gson()
    override suspend fun login(loginRequestModel: LoginRequestModel): Result<LoginResponseModel> {
        return try{
            val result = loginService.login(loginRequestModel)
            result.onSuccess {
                val json = gson.toJson(result)
                val loginResponseDto: LoginResponseDto =
                    gson.fromJson(json, LoginResponseDto::class.java)
                Result.success(loginResponseDto)
            }.onFailure {
                Log.i("TAG", "ERROR: $result")
            }
        }catch (t: Throwable){
            Result.failure(t)
        }
    }

}