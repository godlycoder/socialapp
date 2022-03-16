package id.banidevv.socialapp.data

import id.banidevv.socialapp.data.response.CommentResponse
import id.banidevv.socialapp.data.response.photo.PhotoResponse
import id.banidevv.socialapp.data.response.post.PostResponse
import id.banidevv.socialapp.data.response.user.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("posts")
    suspend fun fetchAllPost() : List<PostResponse>

    @GET("users/{id}")
    suspend fun fetchById(
        @Path("id")
        userId: Int
    ): UserResponse

    @GET("comments")
    suspend fun fetchAllComment(
        @Query("postId")
        postId: Int
    ) : List<CommentResponse>

    @GET("user/{id}/photos")
    suspend fun fetchAllPhoto(
        @Path("id")
        userId: Int
    ): List<PhotoResponse>
}
