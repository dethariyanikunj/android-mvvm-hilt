package com.example.mvvmsampleapp.withhilt.repository

import com.example.mvvmsampleapp.withhilt.network.MyApi
import com.example.mvvmsampleapp.withhilt.response.ApiResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class ApiRepository @Inject constructor(@Named("return") private val myApi: MyApi) {

    suspend fun userLogin(email: String, password: String): Response<ApiResponse> {
        return myApi.userLogin(email, password)
    }
}