package com.example.mvvmsampleapp.onlymvvm

import com.example.mvvmsampleapp.onlymvvm.response.ApiResponse
import retrofit2.Response

interface ApiResponseListener {
    fun onStarted()
    fun onSuccess(response: Response<ApiResponse>)
    fun onFailure()
}