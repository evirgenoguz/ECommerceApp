package com.evirgenoguz.ecommerceapp.util

/**
 * Created by Oguz Evirgen on 21.03.2023.
 */
sealed class RegisterValidation(){

    object Success: RegisterValidation()
    data class Failed(val message: String): RegisterValidation()

}

data class RegisterFieldState(
    val email: RegisterValidation,
    val password: RegisterValidation
)
