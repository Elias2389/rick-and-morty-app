package com.ae.rickandmortyapp.core.di

import com.ae.rickandmortyapp.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {
    private const val TIME_TIMEOUT: Long = 30

    /**
     * Provide interceptor of http requests
     * @return HttpLoggingInterceptor
     */
    @Provides
    fun provideNetworkInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    /**
     * Provide Http client with behaviors
     * @return OkHttpClient
     */
    @Provides
    fun provideOkHttpClient(
        networkInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
            .addNetworkInterceptor(networkInterceptor)
            .connectTimeout(TIME_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIME_TIMEOUT, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
        return httpBuilder.build()
    }

    /**
     * Create interface with retrofit generic class
     * @return service to create
     */
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

}