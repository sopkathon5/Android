package com.icoo.sopkaton_5.ui.main.contents

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.icoo.sopkaton_5.R
import kotlinx.android.synthetic.main.activity_contents_memory.*
import org.jetbrains.anko.startActivity

class ContentsMemoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents_memory)

        img_back_btn_content_act.setOnClickListener {
            finish()
        }
    }

}