package id.banidevv.socialapp.detailpost

import id.banidevv.socialapp.data.repository.comment.CommentRemoteDataSource
import id.banidevv.socialapp.domain.model.CommentModel
import id.banidevv.socialapp.domain.Resource
import id.banidevv.socialapp.domain.repository.comment.CommentRepository
import id.banidevv.socialapp.domain.repository.comment.CommentRepositoryImpl
import id.banidevv.socialapp.utils.BaseUnitTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.lang.RuntimeException


/**
 * Created by Muhamad Ribani on 16/03/22.
 * banidevv@gmail.com
 */


class CommentRepositoryShould : BaseUnitTest() {

    private val remoteDataSource: CommentRemoteDataSource = mock()
    private val postId: Int = 0
    private var repository: CommentRepository = CommentRepositoryImpl(remoteDataSource)

    @Test
    fun getCommentFromRemoteDataSource() = runTest {
        repository.getComment(postId)

        verify(remoteDataSource, times(1)).fetchAll(postId)
    }

    @Test
    fun emitSuccessCase() = runTest {
        whenever(remoteDataSource.fetchAll(postId)).thenReturn(
            listOf()
        )

        repository = CommentRepositoryImpl(remoteDataSource)

        assertEquals(Resource.success(listOf<CommentModel>()), repository.getComment(postId))
    }

    @Test
    fun emitFailureCase() = runTest {
        val exception = RuntimeException("Some error")
        whenever(remoteDataSource.fetchAll(postId)).thenThrow(
            exception
        )

        repository = CommentRepositoryImpl(remoteDataSource)

        assertEquals(Resource.error<CommentModel>(exception), repository.getComment(postId))
    }

}