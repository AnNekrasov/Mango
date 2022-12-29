package android.example.domain.usecase

import android.example.domain.model.CheckSmsCodeDomainModel
import android.example.domain.repository.IUserRepository

class AuthByPhoneUseCase (
    private val userRepository: IUserRepository
) {
    suspend fun postPhoneNumber(phone: String): Boolean {
       return userRepository.postPhoneNumber(phone)
    }

    suspend fun checkSmsCode(code: String, phone: String): CheckSmsCodeDomainModel{
        return userRepository.checkSmsCode(code, phone)
    }
}