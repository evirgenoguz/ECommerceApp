package com.evirgenoguz.ecommerceapp.util

/**
 * Created by Oguz Evirgen on 8.03.2023.
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String): Resource<T>(message = message)
    class Loading<T>: Resource<T>()

    class Unspecified<T>: Resource<T>()
}
