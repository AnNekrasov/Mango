package android.example.data

import android.example.data.model.CheckSmsCodeRequest
import android.example.data.model.PhoneRequest
import android.example.domain.model.CheckSmsCodeDomainModel
import android.example.domain.repository.IUserRepository

class UserRepositoryImpl(
    private val userService: UserService
) : IUserRepository {
    override suspend fun postPhoneNumber(phone: String): Boolean {
        return userService.postPhoneNumber(PhoneRequest(phone))
    }

    override suspend fun checkSmsCode(phone: String, code: String): CheckSmsCodeDomainModel {
        return userService.checkSmsCode(CheckSmsCodeRequest(code = code, phone = phone)).toDomainObject()
    }
}