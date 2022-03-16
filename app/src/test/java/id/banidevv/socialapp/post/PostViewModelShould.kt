package id.banidevv.socialapp.post

import id.banidevv.socialapp.domain.usecase.GetAllPostUseCase
import id.banidevv.socialapp.presenter.post.PostViewModel
import id.banidevv.socialapp.utils.BaseUnitTest
import id.banidevv.socialapp.utils.getValueForTest
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.kotlin.mock


/**
 * Created by Muhamad Ribani on 15/03/22.
 * banidevv@gmail.com
 */

class PostViewModelShould : BaseUnitTest() {

    private val getAllPostUseCase = mock<GetAllPostUseCase>()
    private val viewModel: PostViewModel = PostViewModel(getAllPostUseCase)

    @Test
    fun getAllPostListFromUseCase() = runTest {
        viewModel.getAllPost().getValueForTest()
        verify(getAllPostUseCase, times(1)).execute()
    }

}