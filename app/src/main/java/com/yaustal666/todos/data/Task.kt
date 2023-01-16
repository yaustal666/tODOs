package com.yaustal666.todos.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tasks")
data class Task (
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "date") var date : Long = 0,
    @ColumnInfo(name = "description") var description : String? = "",
    @ColumnInfo(name = "completed") var isCompleted : Boolean = false,
    @ColumnInfo(name = "favorite") var isFavorite : Boolean = false,
    @ColumnInfo(name = "subtask") var isSub : Boolean = false,
    @ColumnInfo(name = "parentId") val parentTask : Int = -1,
    @ColumnInfo(name = "listId") val whatList : Int
) : Parcelable