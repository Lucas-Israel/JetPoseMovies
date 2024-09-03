package br.com.lucasisrael.jetposemovies.common.network

import br.com.lucasisrael.jetposemovies.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class TokenBearerInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("accept", "application/json")
            .addHeader("Authorization", "Bearer " + BuildConfig.TOKEN_BEARER)
            .build()

        return chain.proceed(request)
    }
}