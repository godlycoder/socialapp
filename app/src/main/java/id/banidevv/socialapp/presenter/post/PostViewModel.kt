package id.banidevv.socialapp.presenter.post

import dagger.hilt.android.lifecycle.HiltViewModel
import id.banidevv.socialapp.common.core.BaseViewModel
import id.banidevv.socialapp.domain.usecase.GetAllPostUseCase
import javax.inject.Inject


/**
 * Created by Muhamad Ribani on 15/03/22.
 * banidevv@gmail.com
 */

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getAllPostUseCase: GetAllPostUseCase
) : BaseViewModel() {

    fun getAllPost() = observe {
        getAllPostUseCase.execute()
    }
}