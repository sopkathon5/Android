package com.icoo.sopkaton_5.data.remote.api

import com.icoo.sopkaton_5.data.model.Test.TestResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST

interface NetworkService {

    @POST("/test")
    fun postTest(): Call<TestResponse>

    companion object {
        private const val BASE_URL = ""

        fun create(): NetworkService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService::class.java)
        }
    }
}