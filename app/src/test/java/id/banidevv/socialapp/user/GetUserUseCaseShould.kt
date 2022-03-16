package id.banidevv.socialapp.user

import id.banidevv.socialapp.domain.Resource
import id.banidevv.socialapp.domain.model.UserModel
import id.banidevv.socialapp.domain.repository.user.UserRepository
import id.banidevv.socialapp.domain.usecase.GetUserUseCase
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


class GetUserUseCaseShould : BaseUnitTest() {

    private val repository: UserRepository = mock()
    private val userId: Int = 0
    private var useCase: GetUserUseCase = GetUserUseCase(repository)

    private val userModel = mock<UserModel>()
    private val successExpected = Resource.success(userModel)
    private val failureExpected = Resource.error<UserModel>(RuntimeException())

    @Test
    fun getUserFromRepository() = runTest {
        useCase.execute(userId)

        verify(repository, times(1)).getUser(userId)
    }

    @Test
    fun emitSuccessCase() = runTest {
        whenever(repository.getUser(userId)).thenReturn(
            successExpected
        )

        useCase = GetUserUseCase(repository)

        assertEquals(successExpected, useCase.execute(userId))
    }

    @Test
    fun emitFailureCase() = runTest {
        whenever(repository.getUser(userId)).thenReturn(
            failureExpected
        )

        useCase = GetUserUseCase(repository)

        assertEquals(failureExpected, useCase.execute(userId))
    }

}