package id.banidevv.socialapp.detailpost

import id.banidevv.socialapp.domain.usecase.GetCommentUseCase
import id.banidevv.socialapp.presenter.detailpost.DetailPostViewModel
import id.banidevv.socialapp.utils.BaseUnitTest
import id.banidevv.socialapp.utils.getValueForTest
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify


/**
 * Created by Muhamad Ribani on 16/03/22.
 * banidevv@gmail.com
 */


class DetailPostViewModelShould : BaseUnitTest() {

    private val getCommentUseCase: GetCommentUseCase = mock()
    private val postId: Int = 0
    private var viewModel: DetailPostViewModel = DetailPostViewModel(getCommentUseCase)

    @Test
    fun getCommentsFromUseCase() = runTest {
        viewModel.getComment(postId).getValueForTest()

        verify(getCommentUseCase, times(1)).execute(postId)
    }
}