package com.task.app.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.app.data.Team
import kotlinx.coroutines.launch

class ListViewModel(private val repository: ListRepository) : ViewModel() {

    private val _teamsData = MutableLiveData<List<Team>>()
    val teamsData: LiveData<List<Team>> = _teamsData

    fun getList() {
        viewModelScope.launch {
            sort(Sort.NAME, repository.getList())
        }
    }

    fun sortBy(sort: Sort) {
        viewModelScope.launch {
            sort(sort, repository.fetchList())
        }
    }

    private fun sort(sort: Sort, teams: List<Team>) {
        val sorted = when (sort) {
            Sort.NAME -> teams.sortedBy { it.full_name }
            Sort.WINS -> teams.sortedBy { it.wins }
            Sort.LOSSES -> teams.sortedBy { it.losses }
        }
        _teamsData.value = sorted
    }
}