package id.banidevv.socialapp.domain.repository.user

import id.banidevv.socialapp.data.repository.user.UserRemoteDataSource
import id.banidevv.socialapp.domain.Resource
import id.banidevv.socialapp.domain.model.UserModel

class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun getUser(userId: Int): Resource<UserModel> {

        return try {
            val data = remoteDataSource.fetchById(userId)
            val result = UserModel(data.id, data.name, data.email, data.address.street, data.company.name)
            Resource.success(result)

        } catch (e: Exception) {
            Resource.error(e)
        }
    }

}
