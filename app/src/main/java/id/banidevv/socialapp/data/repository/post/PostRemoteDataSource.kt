package id.banidevv.socialapp.data.repository.post

import id.banidevv.socialapp.data.response.post.PostResponse

interface PostRemoteDataSource {
    suspend fun fetchAll() : List<PostResponse>
}
