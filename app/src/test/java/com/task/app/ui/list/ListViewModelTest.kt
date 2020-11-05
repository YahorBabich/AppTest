package com.task.app.ui.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.task.app.data.Team
import com.task.app.mock.MockListRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ListViewModel
    private lateinit var repository: MockListRepository

    @Before
    fun setup() {
        repository = MockListRepository()
        viewModel = ListViewModel(repository)
    }

    @Test
    fun testGetList() {
        val team = mutableListOf<Team>().apply {
            add(Team(10, "AAA", 10, 50, listOf()))
            add(Team(20, "BBB", 20, 40, listOf()))
            add(Team(30, "CCC", 30, 30, listOf()))
            add(Team(40, "DDD", 40, 20, listOf()))
            add(Team(50, "EEE", 50, 10, listOf()))
        }

        repository.team = team
        viewModel.getList()
        assertEquals(viewModel.teamsData.value, team)
    }

    @Test
    fun testSortBy() {
        val team = mutableListOf<Team>().apply {
            add(Team(40, "DDD", 40, 20, listOf()))
            add(Team(20, "BBB", 20, 40, listOf()))
            add(Team(50, "EEE", 50, 10, listOf()))
            add(Team(10, "AAA", 10, 50, listOf()))
            add(Team(30, "CCC", 30, 30, listOf()))
        }

        repository.team = team
        viewModel.sortBy(Sort.LOSSES)
        assertEquals(viewModel.teamsData.value?.get(0)?.losses, 10)
    }
}