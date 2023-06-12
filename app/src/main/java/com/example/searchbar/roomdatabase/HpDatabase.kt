package com.example.searchbar.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HpEntity::class], version = 1, exportSchema = false)
abstract class HpDatabase: RoomDatabase() {

    abstract fun hpDao(): HpDao

    companion object{
        @Volatile
        private var INSTANCE: HpDatabase? = null

        fun getDatabase(context: Context): HpDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HpDatabase::class.java,
                    "hp_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}