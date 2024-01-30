package com.example.mynews.Domain

sealed class Response<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>:Response<T>()
    class Success<T>(data: T?): Response<T>(data)
    data class Error<T> (val error : String):Response<T>()
    //class Error<T>(message: String, data: T? = null): Response<T>(data, message)
}

