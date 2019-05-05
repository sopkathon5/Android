package com.icoo.sopkaton_5.ui.main.signup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.data.model.base.BaseResponse
import com.icoo.sopkaton_5.data.remote.api.NetworkService
import com.icoo.sopkaton_5.ui.main.MainActivity
import com.icoo.sopkaton_5.ui.main.signIn.SignInActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.startActivity
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private val api: NetworkService = NetworkService.create()

  var selectedSex = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setOnClickListener()
    }

    private fun setOnClickListener(){
        rl_complete_btn_signup__act.setOnClickListener {
            sendData()
        }

        if(rg_btn_sex.checkedRadioButtonId == R.id.rb_btn_man) selectedSex = 0

    }

    private fun sendData() {
        val jsonObject = JSONObject()
        jsonObject.put("email", et_id_signup_act.text)
        jsonObject.put("password", et_password_signup_act.text)
        jsonObject.put("nickname", et_nickname_signup_act.text)

        jsonObject.put("sex", selectedSex)


        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject

        val getKeywordResponse = api.postSignUp("application/json", gsonObject)
        getKeywordResponse.enqueue(object : Callback<BaseResponse> {
            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                if (response.isSuccessful) {
                    startActivity<SignInActivity>()
                    finish()
                }
            }
        })
    }
}
