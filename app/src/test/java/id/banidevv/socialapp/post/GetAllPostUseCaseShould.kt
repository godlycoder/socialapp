package id.banidevv.socialapp.post

import id.banidevv.socialapp.domain.repository.post.PostRepository
import id.banidevv.socialapp.domain.usecase.GetAllPostUseCase
import id.banidevv.socialapp.utils.BaseUnitTest
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify


/**
 * Created by Muhamad Ribani on 15/03/22.
 * banidevv@gmail.com
 */


class GetAllPostUseCaseShould : BaseUnitTest() {


    private val repository: PostRepository = mock()
    private var getAllPostUseCase: GetAllPostUseCase = GetAllPostUseCase(repository)

    @Test
    fun getDataFromRepository() = runTest {
        getAllPostUseCase.execute()

        verify(repository, times(1)).getAllPost()
    }



}