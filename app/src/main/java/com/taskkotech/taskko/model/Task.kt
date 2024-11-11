package com.taskkotech.taskko.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tbl_task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title :String,
    val description :String,
    var date: String,
    var time: String
)
