package id.banidevv.socialapp.data.repository.comment

import id.banidevv.socialapp.data.response.CommentResponse

interface CommentRemoteDataSource {
    suspend fun fetchAll(postId: Int) : List<CommentResponse>
}
