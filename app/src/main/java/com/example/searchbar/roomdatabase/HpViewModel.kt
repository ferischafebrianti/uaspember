package com.example.searchbar.roomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HpViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<HpEntity>>
    private val repository: HpRepository

    init {
        val hpDao = HpDatabase.getDatabase(application).hpDao()
        repository = HpRepository(hpDao)
        readAllData = repository.readAllData
    }

    fun addHp(hpEntity: HpEntity){

        viewModelScope.launch(Dispatchers.IO){
            repository.addHp(hpEntity)
        }
    }

}