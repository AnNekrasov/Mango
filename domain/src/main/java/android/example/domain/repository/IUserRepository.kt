package android.example.domain.repository

import android.example.domain.model.AuthorisationSuccessDomainModel
import android.example.domain.model.CheckSmsCodeDomainModel
import android.example.domain.model.UserRegistrationDomainModel
import android.example.domain.model.profile.User

interface IUserRepository {

    suspend fun postPhoneNumber(phone: String): AuthorisationSuccessDomainModel
    suspend fun checkSmsCode(phone: String, code: String): CheckSmsCodeDomainModel
    suspend fun postUserRegistration(phone: String?, name : String?,userName:String? ):UserRegistrationDomainModel
    suspend fun getUserInfo(token : String) : User //переделать, т.к метод должен быть без параметров

}