package com.cezsmartz.deliveryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.cezsmartz.deliveryapp.R

class MainActivity : AppCompatActivity() {
    var imageViewToRegister: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewToRegister = findViewById(R.id.imageView_go_to_register)
        imageViewToRegister?.setOnClickListener {
            gotoRegister()
        }
    }

    private fun gotoRegister() {
        val myIntent = Intent(this, RegisterActivity::class.java)
        startActivity(myIntent)
    }
}