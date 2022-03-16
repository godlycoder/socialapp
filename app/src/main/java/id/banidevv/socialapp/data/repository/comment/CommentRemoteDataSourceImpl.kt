package id.banidevv.socialapp.data.repository.comment

import id.banidevv.socialapp.data.ApiService
import id.banidevv.socialapp.data.response.CommentResponse

class CommentRemoteDataSourceImpl(private val service: ApiService) : CommentRemoteDataSource {
    override suspend fun fetchAll(postId: Int): List<CommentResponse> {
        return service.fetchAllComment(postId)
    }

}
