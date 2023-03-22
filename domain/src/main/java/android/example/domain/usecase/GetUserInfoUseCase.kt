package android.example.domain.usecase

import android.example.domain.model.profile.User
import android.example.domain.repository.IUserRepository

class GetUserInfoUseCase(private val repository: IUserRepository) {
    suspend fun getUserInfo(token : String) :User {
        return repository.getUserInfo(token)
    }
}