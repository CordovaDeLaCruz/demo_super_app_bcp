package com.demo.features.security.login.domain.model

import java.io.Serializable

data class LoginResponseModel(
    val token: String
): Serializable