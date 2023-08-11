package com.example.mvvmsampleapp.onlymvvm

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsampleapp.R
import com.example.mvvmsampleapp.databinding.ActivityMainBinding
import com.example.mvvmsampleapp.onlymvvm.response.ApiResponse
import retrofit2.Response

class MainActivity : AppCompatActivity(), ApiResponseListener {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.apiResponseListener = this
        binding.viewModel = viewModel
    }

    override fun onStarted() {
        binding.progressBar.visibility = View.VISIBLE
        showMessage("onStarted")
    }

    override fun onSuccess(response: Response<ApiResponse>) {
        binding.progressBar.visibility = View.GONE
        showMessage("$response")
    }

    override fun onFailure() {
        binding.progressBar.visibility = View.GONE
        showMessage("onFailure")
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, "$TAG : $message", Toast.LENGTH_SHORT).show()
    }
}