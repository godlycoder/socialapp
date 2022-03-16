package id.banidevv.socialapp.inject

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import id.banidevv.socialapp.domain.repository.comment.CommentRepository
import id.banidevv.socialapp.domain.repository.photo.PhotoRepository
import id.banidevv.socialapp.domain.repository.post.PostRepository
import id.banidevv.socialapp.domain.repository.user.UserRepository
import id.banidevv.socialapp.domain.usecase.GetAllPostUseCase
import id.banidevv.socialapp.domain.usecase.GetCommentUseCase
import id.banidevv.socialapp.domain.usecase.GetPhotoUseCase
import id.banidevv.socialapp.domain.usecase.GetUserUseCase


/**
 * Created by Muhamad Ribani on 15/03/22.
 * banidevv@gmail.com
 */


@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun providesGetAllPostUseCase(
        repository: PostRepository
    ) : GetAllPostUseCase {
        return GetAllPostUseCase(repository)
    }

    @Provides
    fun providesGetCommentUseCase(
        repository: CommentRepository
    ) : GetCommentUseCase {
        return GetCommentUseCase(repository)
    }

    @Provides
    fun providesGetUserUseCase(
        repository: UserRepository
    ) : GetUserUseCase {
        return GetUserUseCase(repository)
    }

    @Provides
    fun providesGetPhotoUseCase(
        repository: PhotoRepository
    ) : GetPhotoUseCase {
        return GetPhotoUseCase(repository)
    }

}