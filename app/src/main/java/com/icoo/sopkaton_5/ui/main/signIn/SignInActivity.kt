package com.icoo.sopkaton_5.ui.main.signIn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.data.model.base.BaseResponse
import com.icoo.sopkaton_5.data.remote.api.NetworkService
import com.icoo.sopkaton_5.ui.main.MainActivity
import com.icoo.sopkaton_5.ui.main.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_tag_write.*
import org.jetbrains.anko.startActivity
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private val api: NetworkService = NetworkService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        setOnClickListener()
    }

    private fun setOnClickListener(){
        rl_complete_btn_sign_in__act.setOnClickListener {
            sendData()
        }
        rl_complete_text_sign_in__act.setOnClickListener {
            startActivity<SignUpActivity>()
            finish()
        }
    }

    private fun sendData() {
        val jsonObject = JSONObject()
        jsonObject.put("name", et_id_sign_in_act.text)
        jsonObject.put("content", et_password_sign_in_act.text)


        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject

        val getKeywordResponse = api.postSignIn("application/json", gsonObject)
        getKeywordResponse.enqueue(object : Callback<BaseResponse> {
            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                if (response.isSuccessful) {
                    startActivity<MainActivity>()
                    finish()
                }
            }
        })
    }
}
