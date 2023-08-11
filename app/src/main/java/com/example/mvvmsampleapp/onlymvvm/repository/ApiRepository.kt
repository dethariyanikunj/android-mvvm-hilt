package com.example.mvvmsampleapp.onlymvvm.repository

import com.example.mvvmsampleapp.onlymvvm.network.MyApi
import com.example.mvvmsampleapp.onlymvvm.response.ApiResponse
import retrofit2.Response

class ApiRepository {

    suspend fun userLogin(email: String, password: String) : Response<ApiResponse> {
        return MyApi().userLogin(email, password)
    }
}