package com.yaustal666.todos.data

import androidx.room.*

@Dao
interface TaskListDao {

    @Query("SELECT * FROM task_lists")
    fun getTaskLists() : List<TaskList>

    @Insert
    fun addList(list : TaskList)

    @Update
    fun updateList(list : TaskList)

    @Delete
    fun deleteList(list : TaskList)
}