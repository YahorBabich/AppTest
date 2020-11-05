package com.task.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey val id: Int,
    val first_name: String,
    val last_name: String,
    val number: Int,
    val position: String
)