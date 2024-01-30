package com.example.mynews.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynews.Domain.Repository.NewsRealRep
import com.example.mynews.Domain.Response
import com.example.mynews.NewsData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRealRep: NewsRealRep) :ViewModel(){


    //The initial value of _news is Response.Loading(),
    private val _news : MutableStateFlow<Response<NewsData>> = MutableStateFlow(Response.Loading())
    val news:StateFlow<Response<NewsData>> = _news

    fun getNews(country:String,category: String){
        Log.d("NewsViewModel", "getNews called with country: $country")
        viewModelScope.launch(Dispatchers.IO){
           newsRealRep.getNewsHeadline(country,category).collectLatest {
               nr ->
               _news.value =nr
               Log.d("NewsViewModel", "Received news response: $country")
           }
        }
    }
}