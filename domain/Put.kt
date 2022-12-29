data class Put(
    val operationId: String,
    val requestBody: RequestBodyX,
    val responses: Responses,
    val summary: String,
    val tags: List<String>
)