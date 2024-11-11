package com.taskkotech.taskko.repo


import com.taskkotech.taskko.dao.TaskDao
import com.taskkotech.taskko.model.Task

class TaskRepository(private val dao: TaskDao) {
    fun insertTask(task:Task)= dao.insertTask(task)

    fun updateTask(task: Task)=dao.updateTask(task)

    fun deleteTask(task: Task)=dao.deleteTask(task)

    fun getAllTask(): List<Task> =dao.getAllTask()
}