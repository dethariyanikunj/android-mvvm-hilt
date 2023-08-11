package com.example.mvvmsampleapp.withhilt.response

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