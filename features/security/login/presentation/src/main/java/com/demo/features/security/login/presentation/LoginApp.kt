package com.demo.features.security.login.presentation

interface LoginApp {
    fun setToken(token: String?)

    fun getToken(): String?
}