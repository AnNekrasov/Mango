package android.example.data.model

import android.example.data.IResponse
import android.example.domain.model.UserRegistrationDomainModel

data class UserRegistrationResponse (
    val refresh_token: String?,
    val access_token: String?,
    val user_id: Int?
): IResponse<UserRegistrationDomainModel>{
    override fun toDomainObject(): UserRegistrationDomainModel {
      return  UserRegistrationDomainModel(
            refresh_token = refresh_token,
            access_token = access_token,
            user_id = user_id
        )
    }
}
//@JsonClass(generateAdapter = true)
//data class AuthInfoEntity(
//    @Json(name = "accessToken")
//    var accessToken: String,
//    @Json(name = "accessTokenExp")
//    var accessTokenExp: Long,
//    @Json(name = "refreshToken")
//    var refreshToken: String,
//    @Json(name = "refreshTokenExp")
//    var refreshTokenExp: Long,
//    @Json(name = "type")
//    var type: Int? = null
//)

