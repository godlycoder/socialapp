package id.banidevv.socialapp.data.repository.photo

import id.banidevv.socialapp.data.response.photo.PhotoResponse

interface PhotoRemoteDataSource {
    suspend fun fetchAll(userId: Int): List<PhotoResponse>

}
