package id.banidevv.socialapp.data.repository.user

import id.banidevv.socialapp.data.ApiService
import id.banidevv.socialapp.data.response.user.UserResponse


/**
 * Created by Muhamad Ribani on 15/03/22.
 * banidevv@gmail.com
 */


class UserRemoteDataSourceImpl(
    private val service: ApiService
) : UserRemoteDataSource {
    override suspend fun fetchById(userId: Int): UserResponse {
        return service.fetchById(userId)
    }
}