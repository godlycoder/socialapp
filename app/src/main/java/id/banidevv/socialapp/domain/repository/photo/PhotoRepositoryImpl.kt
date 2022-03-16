package id.banidevv.socialapp.domain.repository.photo

import id.banidevv.socialapp.data.repository.photo.PhotoRemoteDataSource
import id.banidevv.socialapp.domain.model.PhotoModel
import id.banidevv.socialapp.domain.Resource


/**
 * Created by Muhamad Ribani on 16/03/22.
 * banidevv@gmail.com
 */


class PhotoRepositoryImpl(private val remoteDataSource: PhotoRemoteDataSource) : PhotoRepository {
    override suspend fun getPhoto(userId: Int): Resource<List<PhotoModel>> {
        return try {
            val data = remoteDataSource.fetchAll(userId).map {
                PhotoModel(it.title, it.url, it.thumbnailUrl)
            }
            Resource.success(data)
        } catch (e: Exception) {
            Resource.error(e)
        }
    }
}