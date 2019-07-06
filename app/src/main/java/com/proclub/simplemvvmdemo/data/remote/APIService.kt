package com.proclub.simplemvvmdemo.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface APIService {
    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String): List<Response.Repo>

    companion object {
        fun create(): APIService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(APIService::class.java)
        }
    }
}