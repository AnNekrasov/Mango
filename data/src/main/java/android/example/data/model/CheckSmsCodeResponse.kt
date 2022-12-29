package android.example.data.model

import android.example.data.IResponse
import android.example.domain.model.CheckSmsCodeDomainModel

data class CheckSmsCodeResponse(
    val access_token: String,
    val is_user_exists: Boolean,
    val refresh_token: String,
    val user_id: Int
) : IResponse<CheckSmsCodeDomainModel> {
    override fun toDomainObject() = CheckSmsCodeDomainModel(
        accessToken = access_token,
        isUserExists = is_user_exists,
        refreshToken = refresh_token,
        userId = user_id
    )
}