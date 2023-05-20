package com.cezsmartz.deliveryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.cezsmartz.deliveryapp.R

class RegisterActivity : AppCompatActivity() {
    var imageViewGoToLogin: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        imageViewGoToLogin = findViewById(R.id.imageView_go_to_login)
        imageViewGoToLogin?.setOnClickListener {
            goToLogin()
        }
    }

    private fun goToLogin() {
        val backIntent = Intent(this, MainActivity::class.java)
        startActivity(backIntent)
    }
}