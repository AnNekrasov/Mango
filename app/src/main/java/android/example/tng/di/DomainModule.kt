package android.example.tng.di

import android.example.domain.repository.IUserRepository
import android.example.domain.usecase.AuthByPhoneUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetUserInfoUseCase(userRepository: IUserRepository): AuthByPhoneUseCase {
        return AuthByPhoneUseCase(userRepository)
    }
}