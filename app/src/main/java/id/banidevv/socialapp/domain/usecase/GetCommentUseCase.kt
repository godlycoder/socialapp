package id.banidevv.socialapp.domain.usecase

import id.banidevv.socialapp.domain.repository.comment.CommentRepository

class GetCommentUseCase(
    private val repository: CommentRepository
) {
    suspend fun execute(postId: Int) = repository.getComment(postId)
}
