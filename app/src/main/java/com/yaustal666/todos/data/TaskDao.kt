package com.yaustal666.todos.data

import androidx.room.*

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks" +
            "WHERE !subtask")
    fun getTasks() : List<Task>

    @Query("SELECT * FROM tasks" +
            "WHERE !subtask AND parent = :parentTask")
    fun getSubs(parentTask : Int) : List<Task>

    @Insert
    fun addTask(task : Task)

    @Update
    fun updateTask(task : Task)

    @Delete
    fun deleteTask(task : Task)
}