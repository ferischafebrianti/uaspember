package com.example.searchbar.roomdatabase

import androidx.lifecycle.LiveData

class HpRepository(private val hpDao: HpDao) {

    val readAllData: LiveData<List<HpEntity>> = hpDao.readAllData()

    suspend fun addHp(hpEntity: HpEntity){
        hpDao.addHp(hpEntity)
    }

}