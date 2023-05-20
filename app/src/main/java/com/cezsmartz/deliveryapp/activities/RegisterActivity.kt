package com.cezsmartz.deliveryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.cezsmartz.deliveryapp.R

class RegisterActivity : AppCompatActivity() {
    var imageViewGoToLogin: ImageView? = null
    var nameEditText: EditText? = null
    var lastnameEditText: EditText? = null
    var emailEditText: EditText? = null
    var phoneEditText: EditText? = null
    var passwordEditText: EditText? = null
    var confirmPasswordEditText: EditText? = null
    var registerBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        imageViewGoToLogin = findViewById(R.id.imageView_go_to_login)
        nameEditText = findViewById(R.id.name_edit_text)
        lastnameEditText = findViewById(R.id.lastname_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        phoneEditText = findViewById(R.id.phone_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        confirmPasswordEditText = findViewById(R.id.pass_confirmation_edit_text)
        registerBtn = findViewById(R.id.register_btn)

        imageViewGoToLogin?.setOnClickListener {
            goToLogin()
        }

        registerBtn?.setOnClickListener {
            register()
        }
    }

    private fun goToLogin() {
        val backIntent = Intent(this, MainActivity::class.java)
        startActivity(backIntent)
    }

    private fun register() {
        val name = nameEditText?.text.toString()
        val lastname = lastnameEditText?.text.toString()
        val email = emailEditText?.text.toString()
        val phone = phoneEditText?.text.toString()
        val password = passwordEditText?.text.toString()
        val confirmPass = confirmPasswordEditText?.text.toString()

        if(isValidForm(name = name,
                lastname = lastname,
                email = email,
                phone = phone,
                password = password,
                confirmPassword = confirmPass)) {
            Toast.makeText(this, "Registro valido", Toast.LENGTH_LONG).show()
        }
    }

    private fun isValidForm( name: String,
                             lastname: String,
                             email: String,
                             phone: String,
                             password: String,
                             confirmPassword: String): Boolean {
        if(email.isNullOrBlank() || password.isNullOrBlank() || name.isNullOrBlank()
            || lastname.isNullOrBlank() || phone.isNullOrBlank()
            || confirmPassword.isNullOrBlank()) {
            Toast.makeText(this, "Alguno de los campos esta vacio", Toast.LENGTH_LONG).show()
            return false
        }

        if(!email.isEmailValid()) {
            Toast.makeText(this, "El email no es valido", Toast.LENGTH_LONG).show()
            return false
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "contrasenas no coinciden", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    private fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
}