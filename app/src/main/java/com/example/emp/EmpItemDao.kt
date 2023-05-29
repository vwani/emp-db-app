package com.example.emp

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface EmpItemDao {


    @Query("SELECT * FROM emp_item_table ORDER BY id ASC")
    fun allEmpItems(): Flow<List<EmpItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmpItem(taskItem: EmpItem)

    @Update
    suspend fun updateEmpItem(taskItem: EmpItem)

    @Delete
    suspend fun deleteEmpItem(taskItem: EmpItem)
}