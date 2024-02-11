package com.sergeikrainyukov.myfavoritefilms.di.modules

import com.google.gson.Gson
import com.sergeikrainyukov.myfavoritefilms.BuildConfig
import com.sergeikrainyukov.myfavoritefilms.data.network.api.FilmsApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.Interceptor.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(provideHttpClient())
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()

    private fun provideHttpClient() = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .addInterceptor(ApiKeyInterceptor())
        .build()

    @Provides
    fun provideFilmsApi(retrofit: Retrofit): FilmsApi =
        retrofit.create(FilmsApi::class.java)

}


class ApiKeyInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        val originalRequest: Request = chain.request()
        val modifiedRequest: Request = originalRequest.newBuilder()
            .header("x-api-key", BuildConfig.API_KEY)
            .build()
        return chain.proceed(modifiedRequest)
    }
}

