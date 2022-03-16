package id.banidevv.socialapp.domain.usecase

import id.banidevv.socialapp.domain.repository.user.UserRepository

class GetUserUseCase(private val repository: UserRepository) {

    suspend fun execute(userId: Int) = repository.getUser(userId)

}
