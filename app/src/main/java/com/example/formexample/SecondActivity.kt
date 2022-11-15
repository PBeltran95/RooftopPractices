package com.example.formexample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.formexample.MainActivity.Companion.CONFIRM_PASSWORD_KEY
import com.example.formexample.MainActivity.Companion.EMAIL_KEY
import com.example.formexample.MainActivity.Companion.PASSWORD_KEY
import com.example.formexample.MainActivity.Companion.USERNAME_KEY

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        recoverInfo()
    }

    private fun recoverInfo() {
        val intent = intent
        with(intent) {
            val username = getStringExtra(USERNAME_KEY)
            val email = getStringExtra(EMAIL_KEY)
            val password = getStringExtra(PASSWORD_KEY)
            val confirmPassword = getStringExtra(CONFIRM_PASSWORD_KEY)
            drawValues(username,email,password,confirmPassword)
        }
    }

    private fun drawValues(
        username: String?,
        email: String?,
        password: String?,
        confirmPassword: String?
    ) {
        val tvUsername = findViewById<TextView>(R.id.tv_username)
        val tvEmail = findViewById<TextView>(R.id.tv_email)
        val tvPassword = findViewById<TextView>(R.id.tv_password)
        val tvConfirmPass = findViewById<TextView>(R.id.tv_confirm_pass)

        tvUsername.text = username
        tvEmail.text = email
        tvPassword.text = password
        tvConfirmPass.text = confirmPassword


    }
}