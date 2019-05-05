package com.icoo.sopkaton_5.ui.main.home.tag.post

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.data.local.SharedPreferenceController
import com.icoo.sopkaton_5.data.model.post.PostModel
import com.icoo.sopkaton_5.data.model.post.PostResponse
import com.icoo.sopkaton_5.data.model.postDetail.PostDetailResponse
import com.icoo.sopkaton_5.data.remote.api.NetworkService
import kotlinx.android.synthetic.main.activity_post.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity() {
    var idx = 0
    private val commentDataList = ArrayList<PostModel>()
    private val api: NetworkService = NetworkService.create()
    private val ctx = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        val intent = getIntent()
        idx = intent.getIntExtra("idx", 0)
        setToolBar()
        loadData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun setToolBar() {
        //툴바
        setSupportActionBar(act_post_tb_toolbar)
        supportActionBar!!.setTitle("")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun loadData() {
        val getKeywordResponse = api.getPostDetail(idx)
        getKeywordResponse.enqueue(object : Callback<PostDetailResponse> {
            override fun onFailure(call: Call<PostDetailResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<PostDetailResponse>, response: Response<PostDetailResponse>) {
                if (response.isSuccessful) {
                    act_post_tv_tag.text =  response.body()!!.data.name
                    act_post_tv_time.text = response.body()!!.data.createdAt
                    act_post_tv_contents.text = response.body()!!.data.content
                    act_post_tv_nickname.text = SharedPreferenceController.getUsername(ctx)//response.body()!!.data.userIdx.toString()
                    act_post_tv_like_cnt.text = response.body()!!.data.heartCount.toString()
                    act_post_tv_comment_cnt.text = response.body()!!.data.commentCount.toString()
//                    postDataList.clear()
//                    postDataList.addAll(response.body()!!.data)
//                    setRecyclerView()
                }
            }
        })
    }


}
