package android.example.data.model

data class CheckSmsCodeRequest(
    val phone: String,
    val code: String
)