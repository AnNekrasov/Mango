package android.example.domain.model

data class CheckSmsCodeDomainModel(
    val accessToken: String?,
    val isUserExists: Boolean,
    val refreshToken: String?,
    val userId: Int?
)
