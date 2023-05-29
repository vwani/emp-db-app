package com.example.emp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EmpItem::class], version = 1, exportSchema = false)
public abstract class EmpItemDatabase : RoomDatabase()
{
    abstract fun empItemDao(): EmpItemDao

    companion object
    {
        @Volatile
        private var INSTANCE: EmpItemDatabase? = null

        fun getDatabase(context: Context): EmpItemDatabase
        {
            return INSTANCE ?: synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EmpItemDatabase::class.java,
                    "emp_item_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}