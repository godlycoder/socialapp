package id.banidevv.socialapp.domain.repository.photo

import id.banidevv.socialapp.domain.model.PhotoModel
import id.banidevv.socialapp.domain.Resource

interface PhotoRepository {
    suspend fun getPhoto(userId: Int): Resource<List<PhotoModel>>

}
