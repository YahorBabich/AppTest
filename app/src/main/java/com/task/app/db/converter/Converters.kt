package com.task.app.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.task.app.data.Player

class Converters {
    @TypeConverter
    fun listToJson(value: List<Player>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Player>::class.java).toList()
}