package com.icoo.sopkaton_5.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.icoo.sopkaton_5.ui.main.contents.ContentsFragment
import com.icoo.sopkaton_5.ui.main.home.HomeFragment
import com.icoo.sopkaton_5.ui.main.myPage.MyPageFragment
import com.icoo.sopkaton_5.ui.main.store.StoreFragment

class MainViewPagerAdapter (fm : FragmentManager, val fCount : Int): FragmentStatePagerAdapter(fm){

    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return HomeFragment()
            1 -> return ContentsFragment()
            2 -> return StoreFragment()
            3 -> return MyPageFragment.newInstance()
            else -> return null
        }
    }

    override fun getCount(): Int = fCount //return fCount
}