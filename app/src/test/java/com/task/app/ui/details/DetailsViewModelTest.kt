package com.task.app.ui.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.task.app.data.Team
import com.task.app.mock.MockDetailsRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DetailsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DetailsViewModel
    private lateinit var repository: MockDetailsRepository

    @Before
    fun setup() {
        repository = MockDetailsRepository()
        viewModel = DetailsViewModel(repository)
    }

    @Test
    fun testDetailsById() {
        val team = Team(0, "FULL", 10, 20, listOf())
        repository.team = team
        viewModel.getDetailsById(0)
        assertEquals(viewModel.teamData.value, team)
    }
}