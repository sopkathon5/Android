package com.icoo.sopkaton_5.ui.main.home.tag.tagWrite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.data.model.base.BaseResponse
import com.icoo.sopkaton_5.data.model.post.PostResponse
import com.icoo.sopkaton_5.data.remote.api.NetworkService
import kotlinx.android.synthetic.main.activity_tag_write.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TagWriteActivity : AppCompatActivity() {
    var idx = 0
    private val api: NetworkService = NetworkService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag_write)
        setToolBar()

        val intent = getIntent()
        idx = intent.getIntExtra("idx", 0)
        when(idx) {
            0 -> {
                act_tag_write_tv_keyword.text = "#MP3"
            }
            1 -> {
                act_tag_write_tv_keyword.text = "#불량식품"
            }
            2 -> {
                act_tag_write_tv_keyword.text = "#체육대회"
            }
            3 -> {
                act_tag_write_tv_keyword.text = "#야자"
            }
        }

        setOnClickListener()
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

    private fun sendData() {
        val jsonObject = JSONObject()
        jsonObject.put("userIdx", 7)//테스트용
        jsonObject.put("keywordIdx", idx)
        jsonObject.put("name", act_tag_write_et_title.text)
        jsonObject.put("content", act_tag_write_et_contents.text)


        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject

        val getKeywordResponse = api.postPost("application/json", gsonObject)
        getKeywordResponse.enqueue(object : Callback<BaseResponse> {
            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                if (response.isSuccessful) {

                }
            }
        })
    }

    private fun setToolBar() {
        //툴바
        setSupportActionBar(act_tag_write_tb_toolbar)
        supportActionBar!!.setTitle("")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun setOnClickListener() {
        act_tag_write_tv_post.setOnClickListener {
            sendData()
        }
    }
}
