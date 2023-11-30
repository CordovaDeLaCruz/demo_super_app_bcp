package com.demo.features.security.login.data.di

import com.demo.features.security.login.domain.repository.LoginRepository
import com.demo.features.security.login.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    fun provideLoginUseCase(loginRepository: LoginRepository) =
        LoginUseCase(loginRepository)
}