package com.example.mvvmsampleapp.onlymvvm.network

import com.example.mvvmsampleapp.BuildConfig
import com.example.mvvmsampleapp.onlymvvm.response.ApiResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<ApiResponse>

    companion object {
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .baseUrl("https://demo6897711.mockable.io/")
                .client(
                    OkHttpClient.Builder().also {
                        if (BuildConfig.DEBUG) {
                            val loggingInterceptor = HttpLoggingInterceptor()
                            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                            it.addInterceptor(loggingInterceptor)
                        }
                    }.build()
                ).addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}