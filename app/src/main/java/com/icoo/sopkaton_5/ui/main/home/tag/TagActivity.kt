package com.icoo.sopkaton_5.ui.main.home.tag

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.icoo.sopkaton_5.R
import kotlinx.android.synthetic.main.activity_tag.*

class TagActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag)
        setToolBar()
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
}
