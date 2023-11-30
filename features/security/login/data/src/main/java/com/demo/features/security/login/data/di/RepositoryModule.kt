package com.demo.features.security.login.data.di

import com.demo.features.security.login.data.api.LoginApi
import com.demo.features.security.login.data.repository.LoginRepositoryImp
import com.demo.features.security.login.domain.repository.LoginRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    fun provideRestRepository(loginApi: LoginApi, gson: Gson): LoginRepository =
        LoginRepositoryImp(loginApi = loginApi, gson = gson)
}