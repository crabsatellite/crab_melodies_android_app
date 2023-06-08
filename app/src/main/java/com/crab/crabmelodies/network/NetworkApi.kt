package com.crab.crabmelodies.network

import Section
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {
    @GET("feed")
    fun getHomeFeed(): Call<List<Section>>
}
