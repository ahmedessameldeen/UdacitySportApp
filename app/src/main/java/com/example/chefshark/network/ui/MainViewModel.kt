package com.example.chefshark.network.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chefshark.network.data.LeaguesRepository
import com.example.chefshark.network.data.model.League
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _leagues : MutableLiveData<List<League>> = MutableLiveData()
    val leagues : LiveData<List<League>> = _leagues

    private val leaguesRepository = LeaguesRepository()

    fun getLeagues() {
        viewModelScope.launch {
            _leagues.value = leaguesRepository.getLeagues()
        }
    }
}