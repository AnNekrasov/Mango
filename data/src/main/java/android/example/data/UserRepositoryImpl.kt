package android.example.data

import android.example.data.model.CheckSmsCodeRequest
import android.example.data.model.PhoneRequest
import android.example.data.model.RegistrationUserRequest
import android.example.domain.model.AuthorisationSuccessDomainModel
import android.example.domain.model.CheckSmsCodeDomainModel
import android.example.domain.model.UserRegistrationDomainModel
import android.example.domain.model.profile.User
import android.example.domain.repository.IUserRepository

class UserRepositoryImpl(
    private val userService: UserService
) : IUserRepository {
    override suspend fun postPhoneNumber(phone: String): AuthorisationSuccessDomainModel {
        return userService.postPhoneNumber(
            //  code = "133337",
            PhoneRequest(phone = phone)
        ).toDomainObject()
    }

    override suspend fun checkSmsCode(phone: String, code: String): CheckSmsCodeDomainModel {
        return userService.checkSmsCode(CheckSmsCodeRequest(phone = phone, code = code))
            .toDomainObject()
    }

    override suspend fun postUserRegistration(
        phone: String?,
        name: String?,
        username: String?
    ): UserRegistrationDomainModel {
        return userService.postUserRegistration(
            RegistrationUserRequest(
                phone = phone,
                name = name,
                username = username
            )
        ).toDomainObject()
    }

    override suspend fun getUserInfo(token: String): User {
        return userService.getUser().toDomainObject()
    }
}