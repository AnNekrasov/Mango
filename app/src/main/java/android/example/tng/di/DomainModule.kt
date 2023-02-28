package android.example.tng.di

import android.example.domain.repository.IUserRepository
import android.example.domain.usecase.AuthByPhoneUseCase
import android.example.domain.usecase.GetUserInfoUseCase
import android.example.domain.usecase.RegUserUseCase
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

    @Provides
    fun provideRegistrationUserUseCase(userRepository: IUserRepository): RegUserUseCase {
        return RegUserUseCase(userRepository)

    }

    @Provides
    fun provideGetUserProfileInfoUseCase(userRepository: IUserRepository): GetUserInfoUseCase {
        return GetUserInfoUseCase(userRepository)
    }

}