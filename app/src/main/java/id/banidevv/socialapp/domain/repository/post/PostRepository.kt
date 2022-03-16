package id.banidevv.socialapp.domain.repository.post

import id.banidevv.socialapp.domain.model.PostModel
import id.banidevv.socialapp.domain.Resource

interface PostRepository {
    suspend fun getAllPost() : Resource<List<PostModel>>
}
