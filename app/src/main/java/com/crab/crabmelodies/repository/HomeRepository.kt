package com.crab.crabmelodies.repository

import Section
import com.crab.crabmelodies.network.NetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepository @Inject constructor(private val networkApi: NetworkApi) {

    suspend fun getHomeSections(): List<Section> = withContext(Dispatchers.IO) {
        delay(3000)
        networkApi.getHomeFeed().execute().body()!!
    }
}
