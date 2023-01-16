package com.yaustal666.todos.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Task::class, TaskList::class], version=1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun taskDAO() : TaskDao
    abstract fun taskListDAO() : TaskListDao
}