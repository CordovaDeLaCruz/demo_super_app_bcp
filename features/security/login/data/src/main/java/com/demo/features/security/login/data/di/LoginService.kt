package com.demo.features.security.login.data.di

import com.demo.features.security.login.data.api.LoginApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class LoginService {

    @Provides
    internal fun provideService(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }

    @Provides
    internal fun provideGson(): Gson {
        return Gson()
    }

}