package id.banidevv.socialapp.data.repository.post

import id.banidevv.socialapp.data.ApiService
import id.banidevv.socialapp.data.response.post.PostResponse

class PostRemoteDataSourceImpl(
    private val service: ApiService
) : PostRemoteDataSource {

    override suspend fun fetchAll(): List<PostResponse> {
        return service.fetchAllPost()
    }

}
