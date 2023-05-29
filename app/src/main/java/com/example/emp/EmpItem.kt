package com.example.emp

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emp_item_table")
class EmpItem(

    @PrimaryKey(autoGenerate = false) var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "dept") var dept: String,
    @ColumnInfo(name = "sal") var sal: Int

)
{

}
