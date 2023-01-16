package com.yaustal666.todos.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskListDao {

    @Query("SELECT * FROM task_lists")
    fun getTaskLists() : Flow<List<TaskList>>

    @Insert
    suspend fun addList(list : TaskList)

    @Update
    suspend fun updateList(list : TaskList)

    @Delete
    suspend fun deleteList(list : TaskList)
}