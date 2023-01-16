package com.yaustal666.todos.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task (
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "date") var date : Long,
    @ColumnInfo(name = "description") var description : String?,
    @ColumnInfo(name = "completed") var isCompleted : Boolean,
    @ColumnInfo(name = "favorite") var isFavorite : Boolean,
    @ColumnInfo(name = "subtask") var isSub : Boolean,
    @ColumnInfo(name = "parentId") val parentTask : Int,
    @ColumnInfo(name = "listId") val whatList : Int
)