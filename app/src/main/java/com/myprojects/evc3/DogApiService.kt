package com.myprojects.evc3

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApiService {
    @GET("breeds/image/random/{count}")
    fun getDogs(@Path("count") count: Int): Call<DogResponse>
}