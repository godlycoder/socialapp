package id.banidevv.socialapp.inject

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.banidevv.socialapp.data.repository.comment.CommentRemoteDataSource
import id.banidevv.socialapp.data.repository.photo.PhotoRemoteDataSource
import id.banidevv.socialapp.data.repository.post.PostRemoteDataSource
import id.banidevv.socialapp.data.repository.user.UserRemoteDataSource
import id.banidevv.socialapp.domain.repository.comment.CommentRepository
import id.banidevv.socialapp.domain.repository.comment.CommentRepositoryImpl
import id.banidevv.socialapp.domain.repository.photo.PhotoRepository
import id.banidevv.socialapp.domain.repository.photo.PhotoRepositoryImpl
import id.banidevv.socialapp.domain.repository.post.PostRepository
import id.banidevv.socialapp.domain.repository.post.PostRepositoryImpl
import id.banidevv.socialapp.domain.repository.user.UserRepository
import id.banidevv.socialapp.domain.repository.user.UserRepositoryImpl


/**
 * Created by Muhamad Ribani on 15/03/22.
 * banidevv@gmail.com
 */


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesPostRepository(
        postRemoteDataSource: PostRemoteDataSource,
        userRemoteDataSource: UserRemoteDataSource,
    ) : PostRepository {
        return PostRepositoryImpl(postRemoteDataSource, userRemoteDataSource)
    }

    @Provides
    fun providesCommentRepository(
        remoteDataSource: CommentRemoteDataSource
    ) : CommentRepository {
        return CommentRepositoryImpl(remoteDataSource)
    }

    @Provides
    fun providesUserRepository(
        remoteDataSource: UserRemoteDataSource
    ) : UserRepository {
        return UserRepositoryImpl(remoteDataSource)
    }

    @Provides
    fun providesPhotoRepository(
        remoteDataSource: PhotoRemoteDataSource
    ) : PhotoRepository {
        return PhotoRepositoryImpl(remoteDataSource)
    }

}