package id.banidevv.socialapp.presenter.detailpost

import dagger.hilt.android.lifecycle.HiltViewModel
import id.banidevv.socialapp.common.core.BaseViewModel
import id.banidevv.socialapp.domain.usecase.GetCommentUseCase
import javax.inject.Inject

@HiltViewModel
class DetailPostViewModel @Inject constructor(
    private val getCommentsUseCase: GetCommentUseCase
    ) : BaseViewModel() {

    fun getComment(postId: Int) = observe {
        getCommentsUseCase.execute(postId)
    }


}
