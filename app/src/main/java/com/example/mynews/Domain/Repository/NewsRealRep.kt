package com.example.mynews.Domain.Repository

import android.util.Log
import com.example.mynews.Domain.Response
import com.example.mynews.NewsData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//i guess from here ot should be implemented
class NewsRealRep @Inject constructor(private val newsRepository: NewsRepository) {

    suspend fun getNewsHeadline(country: String,catagory:String): Flow<Response<NewsData>> {
        return flow {


            val response = newsRepository.getNewsData(country,catagory)

            if(response.isSuccessful && response.body() != null){
                // you're adding a new item to the Flow. Any collectors (subscribers)
                // of this Flow will receive this new item.
                emit(Response.Success(response.body()!!))
            }
            else{
                // Log the error message
                val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                Log.e("NewsHeadline", errorMessage)
                emit(Response.Error("Error fetching data: $errorMessage"))
            }
        }
    }
    // we need this function in viewmodel
    // so we add it in AppModule

}