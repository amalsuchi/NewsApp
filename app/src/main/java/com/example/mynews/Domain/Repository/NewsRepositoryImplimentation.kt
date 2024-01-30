package com.example.mynews.Domain.Repository

import android.util.Log
import com.example.mynews.Data.apiService
import com.example.mynews.Domain.Response
import com.example.mynews.NewsData
import javax.inject.Inject

class NewsRepositoryImplimentation @Inject constructor(
    private val api: apiService
) :NewsRepository{
    override suspend fun getNewsData(country: String,catagory:String):retrofit2.Response<NewsData> {
        return api.getNews(country,catagory)

    }


}