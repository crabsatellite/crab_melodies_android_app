package com.crab.crabmelodies.repository;

import com.crab.crabmelodies.datamodel.Playlist
import com.crab.crabmelodies.network.NetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlaylistRepository @Inject constructor(private val networkApi: NetworkApi) {

  suspend fun getPlaylist(id: Int): Playlist = withContext(Dispatchers.IO) {
    networkApi.getPlaylist(id).execute().body()!!
  }
}