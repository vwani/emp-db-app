package com.example.emp

import android.app.Application

class EmpApplication : Application()
{
    private val database by lazy { EmpItemDatabase.getDatabase(this) }
    val repository by lazy { EmpItemRepository(database.empItemDao()) }
}