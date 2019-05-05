package com.icoo.sopkaton_5.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.data.model.keyword.KeywordModel
import com.icoo.sopkaton_5.data.model.keyword.KeywordResponse
import com.icoo.sopkaton_5.data.remote.api.NetworkService
import com.icoo.sopkaton_5.ui.main.home.tag.TagActivity
import com.icoo.sopkaton_5.util.IHomeClickListener
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment: Fragment(), IHomeClickListener {
    private lateinit var rootView: View
    private val api: NetworkService = NetworkService.create()

    private var reward: String = "3,200"
    private val homeDataList = ArrayList<KeywordModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frag_home_tv_reward.text = reward
        loadData()

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


    private fun loadData() {
        val getKeywordResponse = api.getKeyword()
        getKeywordResponse.enqueue(object : Callback<KeywordResponse> {
            override fun onFailure(call: Call<KeywordResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<KeywordResponse>, response: Response<KeywordResponse>) {
                if (response.isSuccessful) {
                    homeDataList.addAll(response.body()!!.data)
                    setRecyclerView()
                }
            }
        })
    }

    companion object {
        private val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}
