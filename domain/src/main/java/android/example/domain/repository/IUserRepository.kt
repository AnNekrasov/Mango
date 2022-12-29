package android.example.domain.repository

import android.example.domain.model.CheckSmsCodeDomainModel

interface IUserRepository {

    suspend fun postPhoneNumber(phone: String): Boolean
    suspend fun checkSmsCode(phone: String, code: String): CheckSmsCodeDomainModel

}