package id.banidevv.socialapp.domain.repository.user

import id.banidevv.socialapp.domain.Resource
import id.banidevv.socialapp.domain.model.UserModel

interface UserRepository {
    suspend fun getUser(userId: Int) : Resource<UserModel>

}
