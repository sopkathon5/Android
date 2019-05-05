package com.icoo.sopkaton_5.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.data.model.Test.TestModel
import com.icoo.sopkaton_5.ui.main.home.tag.TagActivity
import com.icoo.sopkaton_5.util.IHomeClickListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.rv_home_contents.*
import org.jetbrains.anko.support.v4.startActivity

class HomeFragment: Fragment(), IHomeClickListener {
    private lateinit var rootView: View
    private var reward: String = "3,200"
    private val homeDataList = ArrayList<TestModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeDataList.add(TestModel(0, "", "#MP3", "~04.08"))
        homeDataList.add(TestModel(0, "", "#불량식품", "~04.08"))
        homeDataList.add(TestModel(0, "", "#체육대회", "~04.08"))
        homeDataList.add(TestModel(0, "", "#야자", "~04.08"))
        frag_home_tv_reward.text = reward

        setRecyclerView()
    }

    override fun onItemClick(idx: Int) {
        val intent = Intent(activity, TagActivity::class.java)
        intent.putExtra("idx", idx)
        startActivity(intent)
    }

    private fun setRecyclerView() {
        val homeRecyclerViewAdapter = HomeRecyclerViewAdapter(activity!!, homeDataList)
        frag_home_rv_contents.adapter = homeRecyclerViewAdapter
        frag_home_rv_contents.layoutManager = GridLayoutManager(activity, 2)
        homeRecyclerViewAdapter.setOnItemClickListener(this)
    }

    companion object {
        private val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}
