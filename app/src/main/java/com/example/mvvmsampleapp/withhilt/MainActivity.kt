package com.example.mvvmsampleapp.withhilt

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmsampleapp.R
import com.example.mvvmsampleapp.databinding.ActivityMainWithHiltBinding
import com.example.mvvmsampleapp.withhilt.response.ApiResponse
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ApiResponseListener {

    private lateinit var binding: ActivityMainWithHiltBinding

    //    implementation "androidx.activity:activity-ktx:1.7.2"
    //    implementation "androidx.fragment:fragment-ktx:1.7.2"
    private val mainViewModel: MainViewModel by viewModels()

    companion object {
        private const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_with_hilt)
        mainViewModel.apiResponseListener = this
        binding.viewModel = mainViewModel
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