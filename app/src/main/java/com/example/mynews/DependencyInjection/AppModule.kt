package com.example.mynews.DependencyInjection

import com.example.mynews.Data.apiService
import com.example.mynews.Domain.Repository.NewsRealRep
import com.example.mynews.Domain.Repository.NewsRepository
import com.example.mynews.Domain.Repository.NewsRepositoryImplimentation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNewsApi():apiService{
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
    @Provides
    @Singleton
    fun providesNewsRepository(apiService: apiService) : NewsRepository{
        return NewsRepositoryImplimentation(apiService)
    }

    @Provides
    @Singleton
    fun providesNewsRealRep(newsRepository: NewsRepository) : NewsRealRep{
        return NewsRealRep(newsRepository)
    }


}