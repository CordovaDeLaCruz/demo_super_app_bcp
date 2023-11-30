package com.demo.features.security.login.data.model

import java.io.Serializable

data class LoginRequestDto(
    val email: String,
    val password: String
): Serializable