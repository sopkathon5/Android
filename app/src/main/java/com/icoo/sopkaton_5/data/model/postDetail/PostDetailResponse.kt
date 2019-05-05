package com.icoo.sopkaton_5.data.model.postDetail

import com.icoo.sopkaton_5.data.model.post.PostModel

data class PostDetailResponse(
    val status: Int,
    val message: String,
    val data: PostModel
)