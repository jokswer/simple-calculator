package com.example.simplecalculator.view

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.os.StrictMode.VmPolicy
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.simplecalculator.BuildConfig
import com.example.simplecalculator.R
import com.example.simplecalculator.viewmodel.MainViewModel
import com.example.simplecalculator.databinding.MainLayoutBinding

class MainActivity: AppCompatActivity() {

    private lateinit var mainBinding : MainLayoutBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BuildConfig.DEVELOPER_MODE) {
            StrictMode.setThreadPolicy(
                ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
        }

        setContentView(R.layout.main_layout)

        mainBinding = DataBindingUtil.setContentView(this, R.layout.main_layout)
        viewModel = MainViewModel()

        mainBinding.viewModel = viewModel
    }


}