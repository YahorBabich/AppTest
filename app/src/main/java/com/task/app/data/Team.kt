package com.task.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Team(
    @PrimaryKey val id: Int,
    val full_name: String,
    val losses: Int,
    val wins: Int,
    val players: List<Player>
)
