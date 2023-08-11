package com.example.mvvmsampleapp.onlymvvm.response

/*{
    "code": 200,
    "success": true,
    "message": "Success"
}*/

data class ApiResponse(
    val code: Int,
    val message: String,
    val success: Boolean
)