package com.task.app.ui.details

import com.task.app.data.Team
import com.task.app.db.TeamDao

interface DetailsRepository {
    suspend fun fetchDetailsById(id: Int): Team?
}

class DetailsRepositoryImpl(private val teamDao: TeamDao) : DetailsRepository {

    override suspend fun fetchDetailsById(id: Int): Team? {
        return teamDao.getById(id)
    }
}