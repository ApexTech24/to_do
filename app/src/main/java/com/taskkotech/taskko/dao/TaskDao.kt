package com.taskkotech.taskko.dao

import androidx.room.*
import com.taskkotech.taskko.model.Task

@Dao
interface TaskDao {

    @Insert
    fun insertTask(task:Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("Select * from tbl_task")
    fun getAllTask():List<Task>
}