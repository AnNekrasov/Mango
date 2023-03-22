package android.example.domain.model

data class UserRegistrationDomainModel(
    val refresh_token: String?,
    val access_token: String?,
    val user_id: Int?
)
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