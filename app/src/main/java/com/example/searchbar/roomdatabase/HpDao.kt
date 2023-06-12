package com.example.searchbar.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HpDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHp(hpEntity: HpEntity)

    @Query("SELECT * FROM hp_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<HpEntity>>
}