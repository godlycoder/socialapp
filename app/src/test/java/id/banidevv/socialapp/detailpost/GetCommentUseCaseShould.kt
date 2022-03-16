package id.banidevv.socialapp.detailpost

import id.banidevv.socialapp.domain.model.CommentModel
import id.banidevv.socialapp.domain.Resource
import id.banidevv.socialapp.domain.repository.comment.CommentRepository
import id.banidevv.socialapp.domain.usecase.GetCommentUseCase
import id.banidevv.socialapp.utils.BaseUnitTest
import junit.framework.TestCase.assertEquals
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


class GetCommentUseCaseShould : BaseUnitTest() {

    private val repository: CommentRepository = mock()
    private val postId: Int = 0
    private var useCase: GetCommentUseCase = GetCommentUseCase(repository)

    private val successExpected = Resource.success(listOf<CommentModel>())
    private val failureExpected = Resource.error<List<CommentModel>>(RuntimeException("Some error"))

    @Test
    fun executeGetDataFromRepository() = runTest {
        useCase.execute(postId)

        verify(repository, times(1)).getComment(postId)
    }

    @Test
    fun emmitSuccessfulCase() = runTest {
        whenever(repository.getComment(postId)).thenReturn(
            successExpected
        )

        useCase = GetCommentUseCase(repository)

        assertEquals(successExpected, useCase.execute(postId))
    }

    @Test
    fun emmitFailureCase() = runTest {
        whenever(repository.getComment(postId)).thenReturn(
            failureExpected
        )

        useCase = GetCommentUseCase(repository)

        assertEquals(failureExpected, useCase.execute(postId))
    }

}