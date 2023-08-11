package com.example.mvvmsampleapp.onlymvvm

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmsampleapp.onlymvvm.repository.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null
    var apiResponseListener: ApiResponseListener? = null

    fun onLoginButtonClicked(view: View) {
        apiResponseListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            apiResponseListener?.onFailure()
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            val response = ApiRepository().userLogin(email!!, password!!)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    apiResponseListener?.onSuccess(response)
                } else {
                    apiResponseListener?.onFailure()
                }
            }
        }
    }
}