package id.banidevv.socialapp.data.repository.user

import id.banidevv.socialapp.data.response.user.UserResponse

interface UserRemoteDataSource {
    suspend fun fetchById(userId: Int): UserResponse
}
