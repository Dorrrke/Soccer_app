package com.example.soccer_application.domain.viewModels

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel (application: Application) : AndroidViewModel(application){
    fun getContext() = getApplication<Application>()
    fun getString(@StringRes id: Int): String = getContext().getString(id)
}