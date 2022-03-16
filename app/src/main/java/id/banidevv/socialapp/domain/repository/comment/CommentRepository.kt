package id.banidevv.socialapp.domain.repository.comment

import id.banidevv.socialapp.domain.model.CommentModel
import id.banidevv.socialapp.domain.Resource

interface CommentRepository {
    suspend fun getComment(postId: Int) : Resource<List<CommentModel>>

}
