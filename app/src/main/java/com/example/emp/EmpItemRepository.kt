package com.example.emp

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class EmpItemRepository(private val empItemDao: EmpItemDao)
{
    val allEmpItems: Flow<List<EmpItem>> = empItemDao.allEmpItems()

    @WorkerThread
    suspend fun insertEmpItem(empItem: EmpItem)
    {
        empItemDao.insertEmpItem(empItem)
    }

    @WorkerThread
    suspend fun updateEmpItem(empItem: EmpItem)
    {
        empItemDao.updateEmpItem(empItem)
    }

    @WorkerThread
    suspend fun deleteEmpItem(empItem: EmpItem)
    {
        empItemDao.deleteEmpItem(empItem)
    }
}