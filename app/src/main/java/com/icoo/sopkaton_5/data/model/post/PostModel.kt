package com.icoo.sopkaton_5.data.model.post


data class PostModel(
   val idx: Int,
   val nickname: String,
   val time: String,
   val contents: String,
   val tag: String,
   val likeCnt: Int,
   val commentCnt: Int
)