data class ApiResponse<T>(
    val responseCode: Int,
    val data: T
)