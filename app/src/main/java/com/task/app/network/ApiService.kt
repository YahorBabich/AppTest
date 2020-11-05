package com.task.app.network

import com.task.app.data.Team
import retrofit2.http.GET

interface ApiService {

    @GET("/scoremedia/nba-team-viewer/master/input.json")
    suspend fun getTeams(): ApiResponse<ApiError, List<Team>>
}
