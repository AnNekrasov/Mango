package android.example.data

import android.example.data.model.*
import retrofit2.http.*

interface UserService {
    @POST("api/v1/users/send-auth-code/")
    suspend fun postPhoneNumber(
       // @Header("Authorization") code: String,
        @Body phone: PhoneRequest
    ): AuthorizationSuccessResponse

    @POST("api/v1/users/check-auth-code/")
    suspend fun checkSmsCode(
        @Body code: CheckSmsCodeRequest
    ): CheckSmsCodeResponse

    @GET("api/v1/users/me/")
    suspend fun getUser(
        @Header("Authorization") bearerToken: String,
    ): UserResponse
}