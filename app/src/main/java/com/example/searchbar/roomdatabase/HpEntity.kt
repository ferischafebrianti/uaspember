package com.example.searchbar.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hp_table")
data class HpEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val merk: String,
    val price: String,
    val desk: String
    )