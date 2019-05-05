package com.icoo.sopkaton_5.data.model.post


data class PostModel(
   val idx: Int,
   val tag: String,
   val time: String,
   val contents: String,
   val nickname: String,
   val likeCnt: Int,
   val commentCnt: Int
)