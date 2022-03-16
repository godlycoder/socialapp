package id.banidevv.socialapp.domain.repository.comment

import id.banidevv.socialapp.data.repository.comment.CommentRemoteDataSource
import id.banidevv.socialapp.domain.model.CommentModel
import id.banidevv.socialapp.domain.Resource

class CommentRepositoryImpl(private val remoteDataSource: CommentRemoteDataSource) :
    CommentRepository {
    override suspend fun getComment(postId: Int): Resource<List<CommentModel>> {
        return try {
            val data = remoteDataSource.fetchAll(postId)
                .map {
                    CommentModel(it.name, it.body)
                }
            Resource.success(data)
        } catch (e: Exception) {
            Resource.error(e)
        }
    }

}
