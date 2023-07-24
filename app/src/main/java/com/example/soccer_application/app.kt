package com.example.soccer_application

import android.app.Application
import androidx.room.Room
import com.example.soccer_application.di.component.AppComponent
import com.example.soccer_application.di.component.DaggerAppComponent
import com.example.soccer_application.di.modules.RetrofitModule

class app : Application() {
    lateinit var appComponent: AppComponent
//    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
//        initRoom()
        intiDagger()
    }

//    private fun initRoom() {
//        database = Room.databaseBuilder(this, AppDatabase::class.java, "EasyTrashDBLocal")
//            .allowMainThreadQueries()
//            .build()
//    }

    private fun intiDagger() {
        appComponent = DaggerAppComponent.builder()
            .retrofitModule(RetrofitModule())
            .build()
    }
}