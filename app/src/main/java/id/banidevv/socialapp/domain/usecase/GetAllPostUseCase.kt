package id.banidevv.socialapp.domain.usecase

import id.banidevv.socialapp.domain.repository.post.PostRepository


class GetAllPostUseCase(
    private val repository: PostRepository
) {

    suspend fun execute() = repository.getAllPost()

}
