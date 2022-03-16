package id.banidevv.socialapp.domain.repository.post

import id.banidevv.socialapp.data.repository.post.PostRemoteDataSource
import id.banidevv.socialapp.data.repository.user.UserRemoteDataSource
import id.banidevv.socialapp.domain.model.PostModel
import id.banidevv.socialapp.domain.Resource

class PostRepositoryImpl(
    private val postRemoteDataSource: PostRemoteDataSource,
    private val userRemoteDataSource: UserRemoteDataSource,
) : PostRepository {
    override suspend fun getAllPost(): Resource<List<PostModel>> {
        return try {
            val post = postRemoteDataSource.fetchAll()
            val list = arrayListOf<PostModel>()
            post.forEach {
                val user = userRemoteDataSource.fetchById(it.userId)
                list.add(
                    PostModel(
                    it.id,
                    user.id,
                    it.title,
                    it.body,
                    user.name,
                    user.company.name
                )
                )
            }
            Resource.success(list)
        } catch (e: Exception) {
            Resource.error(e)
        }
    }

}
