package com.icoo.sopkaton_5.ui.main.home.tag

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.data.model.Test.TestModel
import com.icoo.sopkaton_5.data.model.post.PostModel
import com.icoo.sopkaton_5.ui.main.home.HomeRecyclerViewAdapter
import com.icoo.sopkaton_5.ui.main.home.tag.tagWrite.TagWriteActivity
import com.icoo.sopkaton_5.util.IIdxClickListener
import kotlinx.android.synthetic.main.activity_tag.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class TagActivity : AppCompatActivity(), IIdxClickListener {
    private val tagDataList = ArrayList<PostModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag)
        setToolBar()
        setOnClickListener()
        setRecyclerView()

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

    override fun onItemClick(idx: Int) {

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
    private fun setRecyclerView() {
        tagDataList.add(PostModel(0, "#피곤 #졸림", "5분 전", "와 해커톤 너무 졸리다 핵졸리다", "DoorJung", 10, 10))
        tagDataList.add(PostModel(0, "#피곤 #졸림", "5분 전", "와 해커톤 너무 졸리다 핵졸리다", "DoorJung", 10, 10))
        tagDataList.add(PostModel(0, "#피곤 #졸림", "5분 전", "와 해커톤 너무 졸리다 핵졸리다", "DoorJung", 10, 10))
        tagDataList.add(PostModel(0, "#피곤 #졸림", "5분 전", "와 해커톤 너무 졸리다 핵졸리다", "DoorJung", 10, 10))
        tagDataList.add(PostModel(0, "#피곤 #졸림", "5분 전", "와 해커톤 너무 졸리다 핵졸리다", "DoorJung", 10, 10))

        val tagRecyclerViewAdapter = TagRecyclerViewAdapter(this, tagDataList)
        act_tag_rv_post.adapter = tagRecyclerViewAdapter
        act_tag_rv_post.layoutManager = LinearLayoutManager(this)
        tagRecyclerViewAdapter.setOnItemClickListener(this)
    }

    private fun setToolBar() {
        //툴바
        setSupportActionBar(act_tag_tb_toolbar)
        supportActionBar!!.setTitle("")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun setOnClickListener() {
        act_tag_iv_write.setOnClickListener {
            startActivity<TagWriteActivity>()
        }
    }
}
