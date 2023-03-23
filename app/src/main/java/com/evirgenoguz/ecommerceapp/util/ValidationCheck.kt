package com.evirgenoguz.ecommerceapp.util

import android.util.Patterns

/**
 * Created by Oguz Evirgen on 23.03.2023.
 */

fun validateEmail(email: String): RegisterValidation{
    if (email.isEmpty()){
        return RegisterValidation.Failed("Email cannot be empty")
    }
    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
        return RegisterValidation.Failed("Wrong Email Format")
    }

    return RegisterValidation.Success
}

fun validatePassword(password: String): RegisterValidation{
    if (password.isEmpty()){
        return RegisterValidation.Failed("Password cannot be empty")
    }
    if (password.length < 6){
        return RegisterValidation.Failed("Password should contains 6 character")
    }
    return RegisterValidation.Success
}