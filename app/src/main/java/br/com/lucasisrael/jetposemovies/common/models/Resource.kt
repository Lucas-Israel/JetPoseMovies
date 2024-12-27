package br.com.lucasisrael.jetposemovies.common.models

sealed class Resource<T>(val data: T?, val message: String?) {

    class Success<T>(data: T, message: String?): Resource<T>(data, message)
    class Error<T>(data: T?, message: String): Resource<T>(data, message)

}
