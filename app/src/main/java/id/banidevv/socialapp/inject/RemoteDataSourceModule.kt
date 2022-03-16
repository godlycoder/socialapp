package id.banidevv.socialapp.inject

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.banidevv.socialapp.data.ApiService
import id.banidevv.socialapp.data.repository.comment.CommentRemoteDataSource
import id.banidevv.socialapp.data.repository.comment.CommentRemoteDataSourceImpl
import id.banidevv.socialapp.data.repository.photo.PhotoRemoteDataSource
import id.banidevv.socialapp.data.repository.photo.PhotoRemoteDataSourceImpl
import id.banidevv.socialapp.data.repository.post.PostRemoteDataSource
import id.banidevv.socialapp.data.repository.post.PostRemoteDataSourceImpl
import id.banidevv.socialapp.data.repository.user.UserRemoteDataSource
import id.banidevv.socialapp.data.repository.user.UserRemoteDataSourceImpl


/**
 * Created by Muhamad Ribani on 15/03/22.
 * banidevv@gmail.com
 */


@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Provides
    fun providesPostRemoteDataSource(
        service: ApiService
    ) : PostRemoteDataSource {
        return PostRemoteDataSourceImpl(service)
    }

    @Provides
    fun providesUserRemoteDataSource(
        service: ApiService
    ) : UserRemoteDataSource {
        return UserRemoteDataSourceImpl(service)
    }

    @Provides
    fun providesCommentRemoteDataSource(
        service: ApiService
    ) : CommentRemoteDataSource {
        return CommentRemoteDataSourceImpl(service)
    }

    @Provides
    fun providesPhotoREmoteDataSource(
        service: ApiService
    ) : PhotoRemoteDataSource {
        return PhotoRemoteDataSourceImpl(service)
    }

}