package com.yaustal666.todos.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yaustal666.todos.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskDao : TaskDao
) : ViewModel() {

    val tasks = taskDao.getTasks().asLiveData()
}