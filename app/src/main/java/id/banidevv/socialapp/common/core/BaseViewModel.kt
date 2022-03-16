package id.banidevv.socialapp.common.core

import androidx.lifecycle.*
import id.banidevv.socialapp.domain.Resource

open class BaseViewModel : ViewModel() {

    fun <T> observe(block: suspend () -> Resource<T>) = liveData {
        emit(Resource.loading())
        emit(block())
        emit(Resource.finish())
    }

}