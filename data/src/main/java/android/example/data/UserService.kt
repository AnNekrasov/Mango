package android.example.data

import android.example.data.model.CheckSmsCodeRequest
import android.example.data.model.CheckSmsCodeResponse
import android.example.data.model.PhoneRequest
import android.example.data.model.UserResponse
import retrofit2.http.*

interface UserService {
    @POST("v1/users/send-auth-code/")
    suspend fun postPhoneNumber(
        @Body phone: PhoneRequest
    ): Boolean

    @POST("v1/users/check-auth-code/")
    suspend fun checkSmsCode(
        @Body code: CheckSmsCodeRequest
    ): CheckSmsCodeResponse

    @GET("v1/users/me/")
    suspend fun getUser(
        @Header("Authorization") bearerToken: String,
    ): UserResponse
}