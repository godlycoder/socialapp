package id.banidevv.socialapp.user

import id.banidevv.socialapp.data.repository.user.UserRemoteDataSource
import id.banidevv.socialapp.data.response.user.UserResponse
import id.banidevv.socialapp.domain.Resource
import id.banidevv.socialapp.domain.model.UserModel
import id.banidevv.socialapp.domain.repository.user.UserRepository
import id.banidevv.socialapp.domain.repository.user.UserRepositoryImpl
import id.banidevv.socialapp.utils.BaseUnitTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


/**
 * Created by Muhamad Ribani on 16/03/22.
 * banidevv@gmail.com
 */


class UserRepositoryShould : BaseUnitTest() {

    private val remoteDataSource: UserRemoteDataSource = mock()
    private val userId: Int = 0
    private var repository: UserRepository = UserRepositoryImpl(remoteDataSource)

    private val userModel = mock<UserModel>()
    private val userResponse = mock<UserResponse>()
    private val successExpected = Resource.success(userModel)

    @Test
    fun getUserFromRemoteDataSource() = runTest {
        repository.getUser(userId)

        verify(remoteDataSource, times(1)).fetchById(userId)
    }

    @Test
    fun emitSuccessCase() = runTest {
        whenever(remoteDataSource.fetchById(userId)).thenReturn(
            userResponse
        )

        repository = UserRepositoryImpl(remoteDataSource)

        assertEquals(successExpected, repository.getUser(userId))
    }

}