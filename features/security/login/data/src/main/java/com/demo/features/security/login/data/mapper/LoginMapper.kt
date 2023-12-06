package com.demo.features.security.login.data.mapper

import com.demo.features.security.login.data.model.LoginRequestDto
import com.demo.features.security.login.domain.model.LoginRequestModel

fun LoginRequestModel.toDTO() = LoginRequestDto(
    email = email,
    password = password
)
