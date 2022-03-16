package id.banidevv.socialapp.domain.model

data class PostModel(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,
    val userName: String,
    val companyName: String
)
