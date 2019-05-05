package com.icoo.sopkaton_5.data.model.keyword

data class KeywordResponse(
    val status: Int,
    val message: String,
    val data: ArrayList<KeywordModel>
)