package com.demo.superappbcp

import android.app.Application
import com.demo.features.security.login.presentation.LoginApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(), LoginApp {
    private var token: String? = null
    override fun setToken(token: String?) {
        this.token = token
    }

    override fun getToken(): String? {
        return this.token
    }
}