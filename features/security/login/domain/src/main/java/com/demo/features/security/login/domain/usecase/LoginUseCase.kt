package com.demo.features.security.login.domain.usecase

import com.demo.features.security.login.domain.model.LoginRequestModel
import com.demo.features.security.login.domain.model.LoginResponseModel
import com.demo.features.security.login.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend operator fun invoke(loginRequestModel: LoginRequestModel): Result<LoginResponseModel>{
        return loginRepository.login(loginRequestModel = loginRequestModel)
    }
}