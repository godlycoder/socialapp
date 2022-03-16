package id.banidevv.socialapp.data.repository.photo

import id.banidevv.socialapp.data.ApiService
import id.banidevv.socialapp.data.response.photo.PhotoResponse


/**
 * Created by Muhamad Ribani on 16/03/22.
 * banidevv@gmail.com
 */


class PhotoRemoteDataSourceImpl(
    private val service: ApiService
) : PhotoRemoteDataSource {
    override suspend fun fetchAll(userId: Int): List<PhotoResponse> {
        return service.fetchAllPhoto(userId)
    }
}