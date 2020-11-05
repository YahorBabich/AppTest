package com.task.app.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.app.data.Team
import kotlinx.coroutines.launch

class DetailsViewModel(private val repository: DetailsRepository) : ViewModel() {

    private val _teamData = MutableLiveData<Team>()
    val teamData: LiveData<Team> = _teamData

    fun getDetailsById(id: Int) {
        viewModelScope.launch {
            val team = repository.fetchDetailsById(id)
            _teamData.value = team
        }
    }

}