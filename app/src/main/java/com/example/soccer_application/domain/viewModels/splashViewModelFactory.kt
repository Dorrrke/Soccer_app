package com.example.soccer_application.domain.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class splashViewModelFactory (application: Application): ViewModelProvider.Factory {
    var app = application
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SplashViewModel(app) as T
    }
}