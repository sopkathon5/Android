package com.icoo.sopkaton_5.data.model.post


data class PostModel(
   val contentIdx: Int,
   val userIdx: Int,
   val keywordIdx: Int,
   val createdAt: String,
   val name: String,
   val content: String,
   val heartCount: Int,
   val commentCount: Int
)