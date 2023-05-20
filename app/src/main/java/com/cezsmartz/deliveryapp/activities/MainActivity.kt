package com.cezsmartz.deliveryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.cezsmartz.deliveryapp.R

class MainActivity : AppCompatActivity() {
    var imageViewToRegister: ImageView? = null
    var emailEditText: EditText? = null
    var passwordEditText: EditText? = null
    var loginBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewToRegister = findViewById(R.id.imageView_go_to_register)
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginBtn = findViewById(R.id.btn_login)

        imageViewToRegister?.setOnClickListener {
            gotoRegister()
        }

        loginBtn?.setOnClickListener {
            login()
        }
    }

    private fun gotoRegister() {
        val myIntent = Intent(this, RegisterActivity::class.java)
        startActivity(myIntent)
    }

    private fun login() {
        val email = emailEditText?.text.toString()
        val password = passwordEditText?.text.toString()


        if(isValidForm(email, password)) {
            Toast.makeText(this, "El formulario es valido", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "El Formulario no es valido", Toast.LENGTH_LONG).show()
        }
    }

    private fun isValidForm(email: String, password: String ): Boolean {
        if(email.isNullOrBlank() || password.isNullOrBlank()) {
            return false
        }

        if(!email.isEmailValid()) {
            return false
        }
        return true
    }

    private fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
}