package com.example.soccer_application.di.component

import com.example.soccer_application.di.modules.RetrofitModule
import com.example.soccer_application.domain.viewModels.SplashViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class])
@Singleton
interface AppComponent {
    fun inject(viewModel: SplashViewModel)
}