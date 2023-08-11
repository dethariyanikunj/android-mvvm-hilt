package com.example.mvvmsampleapp.withhilt

import com.example.mvvmsampleapp.withhilt.response.ApiResponse
import retrofit2.Response

interface ApiResponseListener {
    fun onStarted()
    fun onSuccess(response: Response<ApiResponse>)
    fun onFailure()
}