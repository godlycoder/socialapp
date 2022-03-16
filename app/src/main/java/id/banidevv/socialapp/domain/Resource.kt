package id.banidevv.socialapp.domain

import java.lang.Exception

data class Resource<out T>(val status: Status, val data: T? = null, val exception: Exception? = null) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = Status.SUCCESS, data = data, exception = null)

        fun <T> error(exception: Exception): Resource<T> =
            Resource(status = Status.ERROR, exception = exception)

        fun <T> finish(): Resource<T> = Resource(status = Status.FINISH)

        fun <T> loading(): Resource<T> = Resource(status = Status.LOADING)
    }
}