package com.crab.crabmelodies.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.crab.crabmelodies.datamodel.Album

@Database(entities = [Album::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}