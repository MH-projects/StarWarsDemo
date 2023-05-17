package com.mh.test.di

import androidx.viewbinding.BuildConfig
import com.mh.data.datasource.remote.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkProvider {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        val connectTimeout = 10L
        val readTimeout = 10L
        val writeTimeout = 10L

        val buildHttpClient by lazy {
            OkHttpClient.Builder()
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
        }

        if (BuildConfig.BUILD_TYPE.contentEquals("debug")) {
            val httpInterceptor = HttpLoggingInterceptor()
            httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            buildHttpClient.addInterceptor(httpInterceptor)
        }

        return Retrofit.Builder()
            .baseUrl("https://akabab.github.io/")
            .client(buildHttpClient.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}