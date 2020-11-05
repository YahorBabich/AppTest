package com.task.app.mock

import com.task.app.data.Team
import com.task.app.ui.list.ListRepository

class MockListRepository : ListRepository {
    lateinit var team: List<Team>

    override suspend fun getList() = team

    override suspend fun fetchList() = team
}