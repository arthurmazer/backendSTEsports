data class LoginResponse(
    val name: String,
    val lastname: String,
    val email: String,
    val subscriptionPlan: SubscriptionPlan,
    val jwt: String
)