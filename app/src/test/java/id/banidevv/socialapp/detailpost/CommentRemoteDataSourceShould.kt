package id.banidevv.socialapp.detailpost

import id.banidevv.socialapp.data.ApiService
import id.banidevv.socialapp.data.repository.comment.CommentRemoteDataSource
import id.banidevv.socialapp.data.repository.comment.CommentRemoteDataSourceImpl
import id.banidevv.socialapp.data.response.CommentResponse
import id.banidevv.socialapp.utils.BaseUnitTest
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


/**
 * Created by Muhamad Ribani on 16/03/22.
 * banidevv@gmail.com
 */


class CommentRemoteDataSourceShould : BaseUnitTest() {

    private val service: ApiService = mock()
    private val postId: Int = 0
    private var remoteDataSource: CommentRemoteDataSource = CommentRemoteDataSourceImpl(service)

    @Test
    fun getCommentFromApi() = runTest {
        remoteDataSource.fetchAll(postId)

        verify(service, times(1)).fetchAllComment(postId)
    }

    @Test
    fun emitSuccessCase() = runTest {
        whenever(service.fetchAllComment(postId)).thenReturn(
            listOf()
        )

        remoteDataSource = CommentRemoteDataSourceImpl(service)
        assertEquals(listOf<CommentResponse>(), remoteDataSource.fetchAll(postId))
    }

    @Test
    fun emitFailureCase() = runTest {
        whenever(service.fetchAllComment(postId)).thenThrow(
            RuntimeException()
        )

        remoteDataSource = CommentRemoteDataSourceImpl(service)
        assertEquals(RuntimeException(), remoteDataSource.fetchAll(postId))
    }

}