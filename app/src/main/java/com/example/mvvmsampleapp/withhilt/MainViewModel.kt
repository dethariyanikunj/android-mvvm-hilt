package com.example.mvvmsampleapp.withhilt

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmsampleapp.withhilt.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {
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
            val response = apiRepository.userLogin(email!!, password!!)
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
