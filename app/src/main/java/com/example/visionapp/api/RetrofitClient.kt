package com.example.visionapp.api

import com.example.visionapp.utils.AppContext
import com.example.visionapp.utils.TokenManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://10.39.45.29:3000/"

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client by lazy {

        OkHttpClient.Builder()

            .addInterceptor { chain ->

                val token = TokenManager(
                    AppContext.context
                ).getToken()

                val request = chain.request()
                    .newBuilder()
                    .apply {

                        if (!token.isNullOrEmpty()) {

                            addHeader(
                                "Authorization",
                                "Bearer $token"
                            )
                        }
                    }
                    .build()

                chain.proceed(request)
            }

            .addInterceptor(logging)
            .build()
    }

    val apiService: ApiService by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(ApiService::class.java)
    }
}