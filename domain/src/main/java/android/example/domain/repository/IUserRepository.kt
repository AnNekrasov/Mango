package android.example.domain.repository

import android.example.domain.model.AuthorisationSuccessDomainModel
import android.example.domain.model.CheckSmsCodeDomainModel
import android.example.domain.model.UserRegistrationDomainModel

interface IUserRepository {

    suspend fun postPhoneNumber(phone: String): AuthorisationSuccessDomainModel
    suspend fun checkSmsCode(phone: String, code: String): CheckSmsCodeDomainModel
    suspend fun postUserRegistration(phone: String?, name : String?,userName:String? ):UserRegistrationDomainModel

}