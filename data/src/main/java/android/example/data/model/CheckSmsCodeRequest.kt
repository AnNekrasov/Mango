package android.example.data.model

data class CheckSmsCodeRequest(
    val code: String,
    val phone: String
)