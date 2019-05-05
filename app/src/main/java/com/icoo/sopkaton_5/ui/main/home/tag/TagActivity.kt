package com.icoo.sopkaton_5.ui.main.home.tag

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.icoo.sopkaton_5.R
import kotlinx.android.synthetic.main.activity_tag.*
import org.jetbrains.anko.toast

class TagActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag)
        setToolBar()
        setOnClickListener()

        val intent = getIntent()
        var idx = intent.getIntExtra("idx", 0)
        when(idx) {
            0 -> {
                act_tag_tv_title.text = "#MP3"
                act_tag_tv_subtitle.text = "음악을 이 놈으로 들었어"
            }
            1 -> {
                act_tag_tv_title.text = "#불량식품"
                act_tag_tv_subtitle.text = "어쩌구저쩌구"
            }
            2 -> {
                act_tag_tv_title.text = "#체육대회"
                act_tag_tv_subtitle.text = "어쩌구저쩌구"
            }
            3 -> {
                act_tag_tv_title.text = "#야자"
                act_tag_tv_subtitle.text = "어쩌구저쩌구"
            }
        }
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
        setSupportActionBar(act_tag_tb_toolbar)
        supportActionBar!!.setTitle("")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
    }

    private fun setOnClickListener() {
        act_tag_iv_write.setOnClickListener {
            toast("새 글 쓰기 테스트다 우히힣")
        }
    }
}
