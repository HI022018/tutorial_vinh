package com.example.huynhvinh.kotlin_task1321.Config

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("aboutus")
    fun getAndroidVersion(@Query("version") version: String): Observable <MyObject>
}