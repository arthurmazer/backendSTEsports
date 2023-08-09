data class SubscriptionPlan(
    val id: Int,
    val planName: String,
    val planDescription: String,
    val isActive: Boolean,
    val subHistory: List<SubscriptionDate>,
    val planPrice: Double?
)