package id.banidevv.socialapp.presenter.user

import dagger.hilt.android.lifecycle.HiltViewModel
import id.banidevv.socialapp.common.core.BaseViewModel
import id.banidevv.socialapp.domain.usecase.GetPhotoUseCase
import id.banidevv.socialapp.domain.usecase.GetUserUseCase
import javax.inject.Inject


/**
 * Created by Muhamad Ribani on 16/03/22.
 * banidevv@gmail.com
 */


@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getPhotoUseCase: GetPhotoUseCase
) : BaseViewModel() {

    fun getUser(userId: Int) = observe {
        getUserUseCase.execute(userId)
    }

    fun getPhoto(userId: Int) = observe {
        getPhotoUseCase.execute(userId)
    }

}