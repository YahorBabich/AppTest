package com.task.app.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.task.app.data.Team

@Dao
interface TeamDao {

    @Query("SELECT * FROM team WHERE id=:id")
    suspend fun getById(id: Int): Team?

    @Query("SELECT * FROM team")
    suspend fun getAll(): List<Team>

    @Insert(onConflict = REPLACE)
    suspend fun insertAll(vararg team: Team)

}