package com.taskkotech.taskko.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.taskkotech.taskko.db.TaskDatabase
import com.taskkotech.taskko.model.Task
import com.taskkotech.taskko.repo.TaskRepository

class TaskViewModel(application: Application): AndroidViewModel(application) {

    private lateinit var repository: TaskRepository
    init {
        val dao = TaskDatabase.getDB(application).getTaskDao()
        repository=TaskRepository(dao)
    }

    fun insertTask(task:Task)= repository.insertTask(task)

    fun updateTask(task: Task)=repository.updateTask(task)

    fun deleteTask(task: Task)=repository.deleteTask(task)

    fun getAllTask(): List<Task> =repository.getAllTask()
}