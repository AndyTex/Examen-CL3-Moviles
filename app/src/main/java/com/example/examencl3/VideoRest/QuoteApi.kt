package com.example.examencl3.VideoRest

import retrofit2.Response
import retrofit2.http.GET

interface QuoteApi {
    @GET("listavideo")
    suspend fun getVideos(): Response<Categories>
}


