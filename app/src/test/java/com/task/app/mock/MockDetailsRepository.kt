package com.task.app.mock

import com.task.app.data.Team
import com.task.app.ui.details.DetailsRepository

class MockDetailsRepository : DetailsRepository {
    lateinit var team: Team
    override suspend fun fetchDetailsById(id: Int) = team

}