package id.banidevv.socialapp.post

import id.banidevv.socialapp.data.ApiService
import id.banidevv.socialapp.data.repository.post.PostRemoteDataSource
import id.banidevv.socialapp.data.repository.post.PostRemoteDataSourceImpl
import id.banidevv.socialapp.data.response.post.PostResponse
import id.banidevv.socialapp.utils.BaseUnitTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


/**
 * Created by Muhamad Ribani on 15/03/22.
 * banidevv@gmail.com
 */


class PostRemoteDataSourceShould : BaseUnitTest() {

    private val service: ApiService = mock()
    private var remoteDataSource: PostRemoteDataSource = PostRemoteDataSourceImpl(service)

    private val successExpected = listOf<PostResponse>()
    private val failureExpected = RuntimeException("Some error")

    @Test
    fun getAllPostFromService() = runTest {
        remoteDataSource.fetchAll()

        verify(service, times(1)).fetchAllPost()
    }

    @Test
    fun emitSuccessCase() = runTest {
        whenever(service.fetchAllPost()).thenReturn(
            successExpected
        )

        remoteDataSource = PostRemoteDataSourceImpl(service)

        assertEquals(successExpected, remoteDataSource.fetchAll())
    }

    @Test
    fun emitFailureCase() = runTest {
        whenever(service.fetchAllPost()).thenThrow(
            failureExpected
        )

        remoteDataSource = PostRemoteDataSourceImpl(service)

        assertEquals(failureExpected, remoteDataSource.fetchAll())
    }
}