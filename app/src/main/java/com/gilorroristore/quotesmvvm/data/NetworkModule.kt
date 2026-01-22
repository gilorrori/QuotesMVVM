package com.gilorroristore.quotesmvvm.data

import com.gilorroristore.quotesmvvm.BuildConfig
import com.gilorroristore.quotesmvvm.data.repositories.QuoteRepositoryImpl
import com.gilorroristore.quotesmvvm.domain.QuoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel((HttpLoggingInterceptor.Level.BODY))

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            //.addInterceptor(new Interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideQuiteApiService(retrofit: Retrofit) : QuoteApiService {
        return retrofit.create(QuoteApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideQuoteRepository(quoteApiService: QuoteApiService) : QuoteRepository {
        return QuoteRepositoryImpl(quoteApiService)
    }
}