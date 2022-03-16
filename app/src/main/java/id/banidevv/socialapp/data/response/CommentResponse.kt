package id.banidevv.socialapp.data.response

data class CommentResponse(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)