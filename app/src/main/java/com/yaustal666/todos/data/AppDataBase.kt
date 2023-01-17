package com.yaustal666.todos.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class, TaskList::class], version=1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun taskDAO() : TaskDao
    abstract fun taskListDAO() : TaskListDao

    class Callback @Inject constructor(
        private val database : Provider<AppDataBase>,
        private val appScope : CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val daoTask =  database.get().taskDAO()

            appScope.launch {
                daoTask.addTask(Task(name = "Wheres my soess", whatList = 1))
                daoTask.addTask(Task(name = "Wheres my soess", whatList = 1))
                daoTask.addTask(Task(name = "Wheres my soess", whatList = 1))
                daoTask.addTask(Task(name = "Wheres my soess", whatList = 1))
                daoTask.addTask(Task(name = "Wheres my soess", whatList = 1))

            }
        }
    }
}