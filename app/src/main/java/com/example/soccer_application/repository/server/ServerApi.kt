package com.example.soccer_application.repository.server

import com.example.soccer_application.domain.models.Response
import io.reactivex.Single
import retrofit2.http.GET

interface ServerApi {
    @GET("leagues/?user=dorrrke&token=20f9f77014b11b464b1ef897c702566c&t=list")
    fun getAllMatches(): Single<Response>
}