package com.yaustal666.todos.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks \n" +
            "WHERE NOT subtask")
    fun getTasks() : Flow<List<Task>>

    @Query("SELECT * FROM tasks \n" +
            "WHERE NOT subtask AND parentId = :parentTask")
    fun getSubs(parentTask : Int) : Flow<List<Task>>

    @Query("SELECT * FROM tasks WHERE (completed <> :completed OR completed = 0)")
    fun getCompleted(completed : Boolean) : Flow<List<Task>>

    @Insert
    suspend fun addTask(task : Task)

    @Update
    suspend fun updateTask(task : Task)

    @Delete
    suspend fun deleteTask(task : Task)
}