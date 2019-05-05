package com.icoo.sopkaton_5.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.icoo.sopkaton_5.data.local.SharedPreferenceController
import com.icoo.sopkaton_5.ui.main.signIn.SignInActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SharedPreferenceController.setUsername(this, "DoorJung")

        startActivity<SignInActivity>()
              finish()

    }
}