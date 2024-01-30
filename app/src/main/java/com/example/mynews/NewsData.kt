package com.example.mynews

data class NewsData(
    val status: String,
    val totalResults : Int,
    val articles: List<Article>
)
data class Article(
    val author: String?,
    val title: String,
    val description:String,
    val url:String?,
    val urlToImage:String?,
    val publisherdAt: String?,
    val content:String?,
    val Source:Source?
)
data class Source(
    val id: String,
    val name:String
)