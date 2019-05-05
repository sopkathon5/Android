package com.icoo.sopkaton_5.data.local

import android.content.Context

object SharedPreferenceController{
    private val APP = "APPKEY"
    private val USER_NAME = "MYNAME"
    private val USER_IDX = "MYKEY"

    fun setUsername(context: Context, username : String)
    {
        val pref = context.getSharedPreferences(APP, Context.MODE_PRIVATE) //현재 내 기기에서만 볼수 있는 데이터
        val editor = pref.edit()
        editor.putString(USER_NAME, username)
        editor.apply()
    }

    fun getUsername(context: Context) : String {
        val pref = context.getSharedPreferences(APP, Context.MODE_PRIVATE) //현재 내 기기에서만 볼수 있는 데이터
        return pref.getString(USER_NAME, "")!!
    }

    fun setUsernameIdx(context: Context, userIdx : String)
    {
        val pref = context.getSharedPreferences(APP, Context.MODE_PRIVATE) //현재 내 기기에서만 볼수 있는 데이터
        val editor = pref.edit()
        editor.putString(USER_IDX, userIdx)
        editor.apply()
    }

    fun getUsernameIdx(context: Context) : String {
        val pref = context.getSharedPreferences(APP, Context.MODE_PRIVATE) //현재 내 기기에서만 볼수 있는 데이터
        return pref.getString(USER_IDX, "")!!
    }


    fun clearSPC(context: Context)
    {
        val pref = context.getSharedPreferences(APP, Context.MODE_PRIVATE) //현재 내 기기에서만 볼수 있는 데이터
        val editor = pref.edit()
        editor.clear()
        editor.apply()
    }
}