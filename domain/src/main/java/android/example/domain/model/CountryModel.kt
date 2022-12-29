package android.example.domain.model

data class CountryModel(
    val code: String,
    val name: String,
    val drawableId: Int,
    val phoneLengths: List<Int>
)