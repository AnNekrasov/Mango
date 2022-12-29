data class Post(
    val operationId: String,
    val requestBody: RequestBody,
    val responses: Responses,
    val summary: String,
    val tags: List<String>
)