package com.example.wheaterapplication.presentation.builder

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://www.metaweather.com/api/"

internal fun createOkHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    val okHttpClient = OkHttpClient.Builder()
    okHttpClient.connectTimeout(10, TimeUnit.SECONDS)
    okHttpClient.readTimeout(10, TimeUnit.SECONDS)
    okHttpClient.addInterceptor(logging)
    okHttpClient.addInterceptor(Interceptor {
        val original = it.request()
        val request = original.newBuilder()
            .header("Accept", "application/json")
            .method(original.method, original.body)
            .build()
        try {
            it.proceed(request)
        } catch (e: NoSuchElementException) {
            Response.Builder()
                .protocol(Protocol.HTTP_1_1)
                .code(500).build()
        }
    })
    return okHttpClient.build()
}

internal fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
}

internal inline fun <reified T> createApi(retrofit: Retrofit): T = retrofit.create(T::class.java)