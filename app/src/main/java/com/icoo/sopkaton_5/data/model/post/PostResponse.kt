package com.icoo.sopkaton_5.data.model.post

data class PostResponse(
    val status: Int,
    val message: String,
    val data: ArrayList<PostModel>
)