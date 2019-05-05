package com.icoo.sopkaton_5.data.remote.api

import com.google.gson.JsonObject
import com.icoo.sopkaton_5.data.model.base.BaseResponse
import com.icoo.sopkaton_5.data.model.keyword.KeywordResponse
import com.icoo.sopkaton_5.data.model.post.PostResponse
import com.icoo.sopkaton_5.data.model.test.TestResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface NetworkService {
    //키워드 조회
    @GET("/content/keyword")
    fun getKeyword(): Call<KeywordResponse>

    //키워드별 게시글 목록 조회
    @GET("/content/keyword/{keywordIdx}")
    fun getPostByKeyword(
        @Path("keywordIdx") keywordIdx: Int
    ): Call<PostResponse>

    //게시글 상세 조회

    //게시글 작성
    @POST("/content")
    fun postPost(
        @Header("Content-Type") content_type: String,
        @Body() body : JsonObject
    ): Call<BaseResponse>

    companion object {
        private const val BASE_URL = "http://52.78.120.172:8082"

        fun create(): NetworkService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService::class.java)
        }
    }
}