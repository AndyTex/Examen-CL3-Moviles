package com.example.examencl3.VideoRest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val baseURL = "https://api.mockfly.dev/mocks/2290133c-0a7f-4f82-87e0-d3c136b53709/"

    fun getRetroFitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
