package com.example.examencl3.VideoRest

import com.google.gson.annotations.SerializedName

data class Categories (
    @SerializedName("categories") val categories: List<QuotesList>
)