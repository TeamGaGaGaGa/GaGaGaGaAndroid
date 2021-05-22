package com.example.gagagagaandroid.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private const val BASE_URL = "http://54.180.159.90:5000/"
    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    private fun provideClient() = OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .build()

    private fun provideRetrofitObject(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(provideClient())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val GAGA_SERVICE = provideRetrofitObject().create(GagaService::class.java)
}