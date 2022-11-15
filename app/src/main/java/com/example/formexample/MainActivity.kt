package com.example.formexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    companion object {
        const val USERNAME_KEY = "username"
        const val EMAIL_KEY = "email"
        const val PASSWORD_KEY = "password"
        const val CONFIRM_PASSWORD_KEY = "confirm_password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupButton()
    }

    private fun setupButton() {
        val button = findViewById<Button>(R.id.btnSignUp)
        button.setOnClickListener {
            makeValidation()
        }
    }

    private fun makeValidation() {
        val etUserName = findViewById<TextInputEditText>(R.id.editTextUserName)
        val etEmail = findViewById<TextInputEditText>(R.id.editTextEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.editTextPassword)
        val etConfirmPass = findViewById<TextInputEditText>(R.id.editTextConfirmPassword)

        val areValidFields =
            etUserName.text.toString().isNotEmpty() && etEmail.text.toString().isNotEmpty() &&
            etPassword.text.toString().isNotEmpty() && etConfirmPass.text.toString().isNotEmpty()



        if (areValidFields) captureValues(etUserName, etEmail, etPassword, etConfirmPass)
        else showSnackError()

    }

    private fun captureValues(
        etUserName: TextInputEditText,
        etEmail: TextInputEditText,
        etPassword: TextInputEditText,
        etConfirmPass: TextInputEditText
    ) {
        val userName = etUserName.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPass.text.toString()

        navigateToSecondScreen(userName,email,password,confirmPassword)
    }

    private fun navigateToSecondScreen(
        userName: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        val intent = Intent(this, SecondActivity::class.java).also {
            it.putExtra(USERNAME_KEY, userName)
            it.putExtra(EMAIL_KEY, email)
            it.putExtra(PASSWORD_KEY, password)
            it.putExtra(CONFIRM_PASSWORD_KEY, confirmPassword)
        }

        startActivity(intent)
    }

    private fun showSnackError() {
        Snackbar.make(findViewById(R.id.constraintParent), "There is at least an empty field", Snackbar.LENGTH_LONG).show()
    }
}
