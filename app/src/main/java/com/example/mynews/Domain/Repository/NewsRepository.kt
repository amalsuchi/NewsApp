package com.example.mynews.Domain.Repository

import com.example.mynews.Data.apiService
import com.example.mynews.Domain.Response
import com.example.mynews.NewsData

interface NewsRepository {
    //if sucsess it returns this type of NewsData
    suspend fun getNewsData(country:String,catagory:String):retrofit2.Response<NewsData>
}