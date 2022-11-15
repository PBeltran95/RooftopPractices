package com.example.permissionrequestexample.view.utils

import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*

fun Fragment.toast(message:String){
    Toast.makeText(this.requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun String.capitalize(): String {
    return this.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(
            Locale.ROOT
        ) else it.toString()
    }
}