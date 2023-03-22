package android.example.domain.usecase

import android.example.domain.model.UserRegistrationDomainModel
import android.example.domain.repository.IUserRepository

class RegUserUseCase(
    private val userRepository: IUserRepository
) {
    suspend fun postUserRegistration(phone: String?, name : String?,username:String? ):UserRegistrationDomainModel{
      return  userRepository.postUserRegistration(phone,name,username)
    }
}