package id.banidevv.socialapp.post

import id.banidevv.socialapp.data.repository.post.PostRemoteDataSource
import id.banidevv.socialapp.data.repository.user.UserRemoteDataSource
import id.banidevv.socialapp.data.response.post.PostResponse
import id.banidevv.socialapp.domain.model.PostModel
import id.banidevv.socialapp.domain.Resource
import id.banidevv.socialapp.domain.repository.post.PostRepository
import id.banidevv.socialapp.domain.repository.post.PostRepositoryImpl
import id.banidevv.socialapp.utils.BaseUnitTest
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


/**
 * Created by Muhamad Ribani on 15/03/22.
 * banidevv@gmail.com
 */


class PostRepositoryShould : BaseUnitTest() {

    private val postRemoteDataSource: PostRemoteDataSource = mock()
    private val userRemoteDataSource: UserRemoteDataSource = mock()
    private var repository: PostRepository = PostRepositoryImpl(postRemoteDataSource, userRemoteDataSource)

    private val successExpected = listOf<PostResponse>()
    private val failureExpected = RuntimeException("Some error")


    @Test
    fun getAllPostFromRemoteDataSource() = runTest {
        repository.getAllPost()

        verify(postRemoteDataSource, times(1)).fetchAll()
    }

    @Test
    fun emitSuccessCase() = runTest {
        whenever(postRemoteDataSource.fetchAll()).thenReturn(
            successExpected
        )

        repository = PostRepositoryImpl(postRemoteDataSource, userRemoteDataSource)
        repository.getAllPost()

        assertEquals(Resource.success(successExpected), repository.getAllPost())
    }

    @Test
    fun emitFailureCase() = runTest {
        whenever(postRemoteDataSource.fetchAll()).thenThrow(
            failureExpected
        )

        repository = PostRepositoryImpl(postRemoteDataSource, userRemoteDataSource)
        repository.getAllPost()

        assertEquals(Resource.error<PostModel>(failureExpected), repository.getAllPost())
    }

}