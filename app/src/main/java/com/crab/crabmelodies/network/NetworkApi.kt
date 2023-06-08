package com.crab.crabmelodies.network

import Section
import com.crab.crabmelodies.datamodel.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkApi {
    @GET("feed")
    fun getHomeFeed(): Call<List<Section>>

    @GET("playlist/{id}")
    fun getPlaylist(@Path("id") id: Int): Call<Playlist>

}
