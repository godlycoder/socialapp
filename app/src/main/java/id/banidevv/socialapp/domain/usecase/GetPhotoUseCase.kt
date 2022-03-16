package id.banidevv.socialapp.domain.usecase

import id.banidevv.socialapp.domain.repository.photo.PhotoRepository

class GetPhotoUseCase(
    private val repository: PhotoRepository
) {
    suspend fun execute(userId: Int) = repository.getPhoto(userId)
}
