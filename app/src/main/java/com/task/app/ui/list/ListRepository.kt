package com.task.app.ui.list

import com.task.app.data.Team
import com.task.app.db.TeamDao
import com.task.app.network.ApiResponse
import com.task.app.network.ApiService

interface ListRepository {
    suspend fun getList(): List<Team>
    suspend fun fetchList(): List<Team>
}

class ListRepositoryImpl(
    private val apiService: ApiService,
    private val teamDao: TeamDao
) : ListRepository {
    override suspend fun getList(): List<Team> {
        when (val apiResponse = apiService.getTeams()) {
            is ApiResponse.Success -> {
                teamDao.insertAll(*apiResponse.response.toTypedArray())
                return apiResponse.response
            }
        }
        return emptyList()
    }

    override suspend fun fetchList(): List<Team> {
        return teamDao.getAll()
    }
}