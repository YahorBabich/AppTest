package com.task.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.task.app.data.Player
import com.task.app.data.Team
import com.task.app.db.converter.Converters

@Database(entities = [Team::class, Player::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDao
}