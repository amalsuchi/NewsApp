package com.example.mynews.Data

import com.example.mynews.Domain.Response
import com.example.mynews.NewsData
import retrofit2.http.GET
import retrofit2.http.Query

interface apiService {
    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country") country:String,
        @Query("category") catagory:String,
        @Query("apiKey") apiKey:String = "eafa3c3620864b1981e0d8725bc50cb9"
    ):retrofit2.Response<NewsData>
}
//GET https://newsapi.org/v2/top-headlines?country=us&apiKey=eafa3c3620864b1981e0d8725bc50cb9