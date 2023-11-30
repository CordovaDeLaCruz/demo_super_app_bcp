package com.demo.features.security.login.data.mapper

import com.demo.features.security.login.data.model.LoginRequestDto
import com.demo.features.security.login.data.model.LoginResponseDto
import com.demo.features.security.login.domain.model.LoginRequestModel
import com.demo.features.security.login.domain.model.LoginResponseModel

fun LoginRequestDto.toDomain() = LoginRequestModel(
    email = email,
    password = password
)

fun LoginResponseDto.toDomain() = LoginResponseModel(
    token = token
)