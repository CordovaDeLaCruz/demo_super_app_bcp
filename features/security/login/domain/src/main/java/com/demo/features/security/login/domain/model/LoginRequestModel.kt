package com.demo.features.security.login.domain.model

import java.io.Serializable

data class LoginRequestModel(
    val email: String,
    val password: String
): Serializable