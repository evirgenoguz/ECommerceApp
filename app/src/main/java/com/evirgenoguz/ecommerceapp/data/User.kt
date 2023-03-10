package com.evirgenoguz.ecommerceapp.data

/**
 * Created by Oguz Evirgen on 8.03.2023.
 */
data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val imagePath: String = ""
) {
    constructor(): this("", "", "", "")
}
