package com.taskkotech.taskko.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.taskkotech.taskko.dao.TaskDao
import com.taskkotech.taskko.model.Task

@Database(
    entities = [Task::class],
    version = 1
)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun getTaskDao():TaskDao

    companion object{
        private var db:TaskDatabase? = null
        fun getDB(context: Context):TaskDatabase{
            if (db==null){
                db= Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "task_db"
                ).allowMainThreadQueries().build()

                return db!!
            }
            return db!!
        }
    }
    /*abstract val taskDao: TaskDao
    companion object{
        @Volatile
        private var INSTANCE: TaskDatabase? = null
        fun getInstance(context:Context): TaskDatabase{
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "task_db"
                ).build().also {
                    INSTANCE=it
                }
            }
        }
    }*/
}