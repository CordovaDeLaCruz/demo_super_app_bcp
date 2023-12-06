package com.demo.features.security.login.data.di

import com.demo.features.security.login.data.repository.LoginRepositoryImp
import com.demo.features.security.login.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {
    @Provides
    @Singleton
    fun provideLoginRepository(
        loginService: LoginService
    ): LoginRepository{
        return LoginRepositoryImp(
            loginService
        )
    }
}