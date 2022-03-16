package id.banidevv.socialapp.inject

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.banidevv.socialapp.BuildConfig
import id.banidevv.socialapp.common.network.okHttpClient
import id.banidevv.socialapp.common.network.retrofitClient
import id.banidevv.socialapp.data.ApiService
import okhttp3.OkHttpClient


/**
 * Created by Muhamad Ribani on 16/03/22.
 * banidevv@gmail.com
 */


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesOkHttpClient() : OkHttpClient {
        return okHttpClient(BuildConfig.DEBUG).build()
    }

    @Provides
    fun providesApiService(
        okHttpClient: OkHttpClient
    ) : ApiService {
        val retrofit = retrofitClient(okHttpClient, BuildConfig.BASE_URL)
        return retrofit.create(ApiService::class.java)
    }

}