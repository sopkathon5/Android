package com.icoo.sopkaton_5.ui.main.contents

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.ui.main.home.tag.TagActivity
import kotlinx.android.synthetic.main.fragment_contents.*
import kotlinx.android.synthetic.main.fragment_contents.view.*
import org.jetbrains.anko.support.v4.startActivity

class ContentsFragment : Fragment() {
    private lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_contents, container, false)


        rootView.img_contents1_frag.setOnClickListener(){
            var intent = Intent(activity, ContentsMemoryActivity::class.java)
            startActivity(intent)
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    companion object {
        private val TAG = "ContentsFragment"

        fun newInstance(): ContentsFragment {
            return ContentsFragment()
        }
    }

}
