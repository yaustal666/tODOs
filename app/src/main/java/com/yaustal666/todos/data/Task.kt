package com.yaustal666.todos.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tasks")
data class Task (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "date") val date : Long = 0,
    @ColumnInfo(name = "description") val description : String? = "",
    @ColumnInfo(name = "completed") val isCompleted : Boolean = false,
    @ColumnInfo(name = "favorite") val isFavorite : Boolean = false,
    @ColumnInfo(name = "subtask") val isSub : Boolean = false,
    @ColumnInfo(name = "parentId") val parentTask : Int = -1,
    @ColumnInfo(name = "listId") val whatList : Int
) : Parcelable