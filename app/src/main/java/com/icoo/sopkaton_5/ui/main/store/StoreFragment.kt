package com.icoo.sopkaton_5.ui.main.store

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.data.model.storeItem.StoreIteamData
import kotlinx.android.synthetic.main.fragment_store.*


class StoreFragment : Fragment() {
    private lateinit var rootView: View
    lateinit var storeRecyclerViewAdapter : StoreRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_store, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMyRecyclerView()
    }


    companion object {
        private val TAG = "StoreFragment"

        fun newInstance(): StoreFragment {
            return StoreFragment()
        }
    }

    private fun setMyRecyclerView(){

        var dataList: ArrayList<StoreIteamData> = ArrayList()
        dataList.add(
            StoreIteamData(
                "차카니",
                "980원",
                "이룸",
                R.drawable.market_card_image_1
            )
        )
        dataList.add(
            StoreIteamData(
                "아폴로(10봉)",
                "4,080원",
                "하트쏠라씨",
                R.drawable.market_card_2
            )
        )
        dataList.add(
            StoreIteamData(
                "라면짱",
                "1,080원",
                "이룸",
                R.drawable.market_card_image_3
            )
        )
        dataList.add(
            StoreIteamData(
                "호박맛 쫀드(20)",
                "6,790원",
                "땅콩씨엔에프",
                R.drawable.market_card_image_4
            )
        )
        dataList.add(
            StoreIteamData(
                "감자알칩(20봉)",
                "8,000원",
                "빅보이유통",
                R.drawable.market_card_5
            )
        )


        storeRecyclerViewAdapter = StoreRecyclerViewAdapter(activity!!, dataList)
        rv_store_list.adapter=storeRecyclerViewAdapter
        rv_store_list.layoutManager= LinearLayoutManager(context)
    }
}
