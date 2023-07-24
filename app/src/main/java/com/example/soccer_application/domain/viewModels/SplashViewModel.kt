package com.example.soccer_application.domain.viewModels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.MutableLiveData
import com.example.soccer_application.app
import com.example.soccer_application.domain.models.DataItem
import com.example.soccer_application.domain.models.Response
import com.example.soccer_application.repository.server.ServerApi
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SplashViewModel(application: Application) : BaseViewModel(application) {
    @Inject
    lateinit var server: ServerApi



    val matchList = MutableLiveData<List<DataItem?>?>()
    private val compositeDisposable = CompositeDisposable()

    init {
        (application as app).appComponent.inject(this)
    }

    fun getAllMatches(){
        server.let {
            compositeDisposable.add(server.getAllMatches().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnError{ t: Throwable -> Log.e("ServerCommunicator", t.message!!) }
                .subscribe { list -> Log.e("Why", list.data?.get(0)!!.id!!)
                    matchList.value = list.data})
        }

    }
}